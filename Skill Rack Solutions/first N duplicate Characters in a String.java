#include<stdio.h>
#include<stdlib.h>

int main()
{
    char str[1001];
    scanf("%s",str);
    int len = strlen(str);
    
    int n;
    scanf("%d",&n);
    
    int count[127]={0};
    int limit=0;

    for(int i=0;i<len;i++)
    {
        count[str[i]]++;
        if(count[str[i]]==2) limit++;
        if(limit==n) break;
    }
    
    for(int i=0;i<len;i++)
    {
        if(count[str[i]]>=2)
        {
            printf("%c",str[i]);
        }
    }
    return 0;
}