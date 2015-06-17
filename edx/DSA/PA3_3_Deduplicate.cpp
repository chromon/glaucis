/*
描述
Epicure先生正在编撰一本美食百科全书。为此，他已从众多的同好者那里搜集到了一份冗长的美食提名清单。既然源自多人之手，其中自然不乏重复的提名，故必须予以筛除。Epicure先生因此登门求助，并认定此事对你而言不过是“一碟小菜”，相信你不会错过在美食界扬名立万的这一良机

输入
第1行为1个整数n，表示提名清单的长度。以下n行各为一项提名

输出
所有出现重复的提名（多次重复的仅输出一次），且以其在原清单中首次出现重复（即第二次出现）的位置为序

样例
Input
10
brioche
camembert
cappelletti
savarin
cheddar
cappelletti
tortellni
croissant
brioche
mapotoufu

Output
cappelletti
brioche

限制
1 < n < 6 * 10^5

提名均由小写字母组成，不含其它字符，且每项长度不超过40

时间：2 sec

空间：256 MB

提示
散列
*/
#include <cstdio>
#include <cstdlib>
#include <cstring>

#define MAXN 600005

const int SZ = 1<<19;
struct fastio
{
    char inbuf[SZ];char outbuf[SZ];fastio()
    {//输入输出挂
        setvbuf(stdin,inbuf,_IOFBF,SZ);
        setvbuf(stdout,outbuf,_IOFBF,SZ);
    }
}io;

struct Node
{
    char foodName[45];
    Node *next;
    Node *prev;
    bool appeared;
    
    Node()
    {
        foodName[0] = '\0';
        appeared = false;
        next = NULL;
        prev = NULL;
    }
};

class hashNode
{
private:
    int size;
    Node *head;
    Node *tail;
    void init()
    {
        size = 0;
        head = new Node;
        tail = new Node;
        head->next = tail;
        tail->prev = head;
    }

public:
    hashNode()
    {
        init();
    }
    
    void addNode(Node *p)
    {
        head->next->prev = p;
        p->next = head->next;
        head->next = p;
        p->prev = head;
        
        size++;
    }
    Node *getHead()
    {
        return head->next;
    }
    

    Node* inHashNodeList(Node *p)
    {
        Node *q = new Node;
        for (q = head; q != tail; q = q->next)
        {
            if (strcmp(q->foodName, p->foodName) == 0)
                return q;
        }
        return NULL;
    }
}foodList[MAXN];

int calHash(char key[])
{
    int h = 0;
    int i = 0;
    while (key[i] != '\0')
    {
        h = (h << 5)|(h >> 27);
        h += (int)key[i];
        i++;
    }
    h = h > 0 ? h: -h;
    return h % 350377;
}

int main(int argc, const char * argv[])
{
    int n, key;
    char temp[45];
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%s", &temp);
        key = calHash(temp);
        Node *food = new Node;
        strcpy(food->foodName, temp);
        
        Node *p = foodList[key].inHashNodeList(food);
        if (p == NULL)
        {
            foodList[key].addNode(food);
        }
        
        else
        {
            if (p->appeared == false)
            {
                printf("%s\n", food->foodName);
                p->appeared = true;
            }
        }
    }
    return 0;
}