namespace hash
{
    class Program
    {
        public static void Main(String[] args)
        {
            MyHash hash = new MyHash(7);
            hash.AddHash(new Node(49));
            hash.AddHash(new Node(58));
            hash.AddHash(new Node(65));
            hash.AddHash(new Node(35));
            hash.AddHash(new Node(22));
            hash.AddHash(new Node(59));
            hash.PrintHash();
            // OUTPUT =  | 49 | 35 | 58 | 65 | 59 | 22 | null |

            hash = new MyHash(11);
            hash.AddHash(new Node(39));
            hash.AddHash(new Node(59));
            hash.AddHash(new Node(61));
            hash.AddHash(new Node(24));
            hash.AddHash(new Node(54));
            hash.AddHash(new Node(77));
            hash.AddHash(new Node(63));
            hash.AddHash(new Node(85));
            hash.AddHash(new Node(41));
            hash.PrintHash();
            // OUTPUT =  | 77 | 41 | 24 | null | 59 | null | 39 | 61 | 63 | 85 | 54 |

            hash = new MyHash(10);
            hash.AddHash(new Node(89));
            hash.AddHash(new Node(18));
            hash.AddHash(new Node(49));
            hash.AddHash(new Node(58));
            hash.AddHash(new Node(69));
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
    public void AddHash(Node node)
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