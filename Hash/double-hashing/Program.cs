namespace hash
{
    class Program
    {
        public static void Main(String[] args)
        {
            /* Double Hashing
            Properties
            ----------
            Node[] hashTable;
            int N; // Hash table size
            int PRIME; // Smallest prime number less than table size(N)

            Methods
            -------
            public int hash1(int key) --> key % N
            public int hash2(int key) --> PRIME - (KEY % PRIME)
            public void Insert(Node node) --> void
            public int GetBiggestPrimeNumber(int number) --> int
            public bool IsPrime(int number) --> boolean
            public void PrintHash() --> void
            */

            MyHash hash = new MyHash(11);
            hash.Insert(new Node(23));
            hash.Insert(new Node(12));
            hash.Insert(new Node(88));
            hash.Insert(new Node(56));
            hash.Insert(new Node(62));
            hash.Insert(new Node(7));
            hash.Insert(new Node(1));
            hash.PrintHash();
            // OUTPUT =  | 88 | 23 | 1 | 12 | null | null | null | 62 | 56 | null | 7 |
            /* 
            Description ( Prime number 7)
            -----------
            1. KEY = 23
            --> Hash1: 23 % 11 = 1. 1th index is null. Put 23 at index 1.

            2. KEY = 12
            --> Hash1: 12 % 11 = 1. 1th index is not null. 
            --> Hash2: 7 - (12 % 7) = 2
            --> Result: (1 + 2) % 7 = 3. 3rd index is null. Put 12 at index 3

            3. KEY = 88
            --> Hash1: 88 % 11 = 0. 0 is null. Put the 88 at index 0.
            
            4. KEY = 56
            --> Hash1: 56 % 11 = 1. 1st index is not null.
            --> Hash2: 7 - (56 % 7) = 7
            --> Result: (1 + 7) % 11 = 8. 8th index is null. Put 56 at index 8.

            5. KEY = 62
            --> Hash1: 62 % 11 = 7. 7th is null. Put 62 at index 7.

            6. KEY = 7
            --> Hash1: 7 % 11 = 7. 7th is not null.
            --> Hash2: 7 - (7 % 7) = 7
            --> Try: 7 + 1*7 = 14 % 11 = 3. 3th is not null.
            --> Result: 7 + 2*7 = 21 % 11 = 10. 10th is null. Put 7 at index 10.
            
            7. KEY = 1
            --> Hash1: 1 % 11 = 1. 1st index is not null.
            --> Hash2: 7 - (1 % 7) = 6
            --> Try: 1 + 1*6 = 7 % 11 = 7. 7th is not null.
            --> Result: 1 + 2*6 = 13 % 11 = 2. 2nd is null. Put 1 at index 2.
            */

            hash = new MyHash(10);
            hash.Insert(new Node(89));
            hash.Insert(new Node(18));
            hash.Insert(new Node(49));
            hash.Insert(new Node(58));
            hash.Insert(new Node(69));
            hash.PrintHash();
            // OUTPUT = | 69 | null | null | 58 | null | null | 49 | null | 18 | 89 |

            hash = new MyHash(7);
            hash.Insert(new Node(49));
            hash.Insert(new Node(58));
            hash.Insert(new Node(65));
            hash.Insert(new Node(35));
            hash.Insert(new Node(22));
            hash.Insert(new Node(59));
            hash.PrintHash();
            // OUTPUT =  | 49 | 22 | 58 | 35 | 59 | 65 | null |

            hash = new MyHash(11);
            hash.Insert(new Node(39));
            hash.Insert(new Node(59));
            hash.Insert(new Node(61));
            hash.Insert(new Node(24));
            hash.Insert(new Node(54));
            hash.Insert(new Node(77));
            hash.Insert(new Node(63));
            hash.Insert(new Node(85));
            hash.Insert(new Node(41));
            hash.PrintHash();
            // OUTPUT =  | 77 | null | 24 | 85 | 59 | null | 39 | 63 | 61 | 41 | 54 |

            hash = new MyHash(10);
            hash.Insert(new Node(89));
            hash.Insert(new Node(18));
            hash.Insert(new Node(49));
            hash.Insert(new Node(58));
            hash.Insert(new Node(69));
            hash.PrintHash();
            // OUTPUT =  | 69 | null | null | 58 | null | null | 49 | null | 18 | 89 |
        }
    }
}
class Node
{
    public int key = 0;
    public Node(int key)
    {
        this.key = key;
    }
}

class MyHash
{
    Node[] hashTable;
    int N; // Hash table size
    int PRIME; // Smallest prime number less than table size(N)
    public MyHash(int N)
    {
        this.hashTable = new Node[N];
        this.N = N;
        this.PRIME = this.GetBiggestPrimeNumber(N);
    }

    public int hash1(int key)
    {
        // First hash fucntion
        return key % this.N;
    }
    public int hash2(int key)
    {
        // Second hash function
        return this.PRIME - (key % this.PRIME);
    }

    public void Insert(Node node)
    {
        int hash1 = this.hash1(node.key);
        int hash2 = this.hash2(node.key);

        int idx = hash1;
        int count = 1;
        while (this.hashTable[idx] != null)
        {
            idx = (hash1 + (count * hash2)) % this.N;
            count++;
        }
        this.hashTable[idx] = node;
    }
    public int GetBiggestPrimeNumber(int number)
    {
        for (int i=number-1; i >= 2; i--)
        {
            if (IsPrime(i))
            {
                return i;
            }
        }
        return -1;
    }
    public bool IsPrime(int number)
    {
        for (int i = 2; i < number; i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }
    public void PrintHash()
    {
        Console.Write(" | ");
        for (int i = 0; i < this.hashTable.Length; i++)
        {
            if (this.hashTable[i] == null)
            {
                Console.Write("null | ");
                continue;
            }
            Console.Write(this.hashTable[i].key + " | ");
        }
        Console.WriteLine();
    }
}