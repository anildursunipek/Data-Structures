namespace hash
{
    class Program
    {
        public static void Main(String[] args)
        {
            /* Anıl Dursun İpek - 031890131
             * Quadratic Hashing
            Properties
            ----------
            Node[] hashTable;
            int N; // Hash table size

            Methods
            -------
            public int hash1(int key) --> key % N
            public void Insert(Node node) --> void
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
            /* 
            Description
            -----------
            1. KEY = 23
            --> Hash: 23 % 11 = 1. 1st is null. Put 23 at index 1.

            2. KEY = 12
            --> Hash: 12 % 11 = 1. 1st is not null.
            --> Quadratic: 1 + (1^2) = 2 % 11 = 2. 2 is null. Put 12 at index 2.

            3. KEY = 88
            --> Hash: 88 % 11 = 0. 0 is null. Put 88 at index 0.

            4. KEY = 56
            --> Hash: 56 % 11 = 1. 1st is not null.
            --> Quadratic: 1 + (1^2) = 2 % 11 = 2. 2nd is not null.
            --> Quadratic2: 1 + (2^2) = 5 % 11 = 5. 5th is null. Put 56 at index 5.

            5. KEY = 62
            --> Hash: 62 % 11 = 7. 7th is null. Put 62 at index 7.

            6. KEY = 7
            --> Hash: 7 % 11 = 7. 7th is not null.
            --> Quadratic: 7 + (1^2) = 8. 8th is null. Put 7 at index 8.
            
            7. KEY = 1
            --> Hash: 1 % 11 = 1. 1st is not null.
            --> Quadratic: 1 + (1^2) = 2. 2nd is not null.
            --> Quadratic2: 1 + (2^2) = 5. 5th is not null.
            --> Quadratic3: 1 + (3^2) = 10 % 11 = 10. 10th is null. Put 1 at index 10.

            INDEX=      0.   1.  2.   3.    4.     5.     6.    7.   8.    9.   10.
            OUTPUT =  | 88 | 23 | 12 | null | null | 56 | null | 62 | 7 | null | 1 |
            */

            hash = new MyHash(7);
            hash.Insert(new Node(49));
            hash.Insert(new Node(58));
            hash.Insert(new Node(65));
            hash.Insert(new Node(35));
            hash.Insert(new Node(22));
            hash.Insert(new Node(59));
            hash.PrintHash();
            // OUTPUT =  | 49 | 35 | 58 | 65 | 59 | 22 | null |

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
            // OUTPUT =  | 77 | 41 | 24 | null | 59 | null | 39 | 61 | 63 | 85 | 54 |

            hash = new MyHash(10);
            hash.Insert(new Node(89));
            hash.Insert(new Node(18));
            hash.Insert(new Node(49));
            hash.Insert(new Node(58));
            hash.Insert(new Node(69));
            hash.PrintHash();
            // OUTPUT =   | 49 | null | 58 | 69 | null | null | null | null | 18 | 89 |
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
    public MyHash(int N)
    {
        this.hashTable = new Node[N];
        this.N = N;
    }

    public int HashCode(int key)
    {
        return key % this.N;
    }
    public void Insert(Node node)
    {
        int idx = this.HashCode(node.key);
        int temp = idx;
        int count = 1;
        while (this.hashTable[temp] != null)
        {
            temp = (int)((idx + Math.Pow(count, 2)) % this.N);
            count++;
        }
        this.hashTable[temp] = node;
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