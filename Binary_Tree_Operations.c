#include <stdio.h>
#include<stdlib.h>

//    TOPICS    

/* 
  main code                                      = 

  1) level order                                 = 115
  2) reverse level order                         =  93 
  3) deepest node in binary tree                 = 131
  4) Find minimum node                           = 148
  5) delete a Node in treee                      = 155 
  6) no of leaf nodes in tree without recursion  = 206
  7) no of half nodes in tree without recursion  = 222 
  8) no of full nodes in tree without recursion  = 238
  9) Maximum Sum level                           = 255
  10)print level order level by level            = 288
  11)print out all its root-to-leaf paths        = 312
  12)Height of tree                              = 334
  13)Total Sum of all nodes                      = 354
  14)Total Sum of all nodes without recursion    = 364
  15) Convert tree to Its Mirror                 = 379
  16) Check trees are mirrors of each other/not  = 393
  17) Mystyle of Get Mirror                      = 421
*/

typedef struct TreeNode 
{
  int data;
  struct TreeNode *left,*right;
}node;

node* getNode(int data)
{
  node *nn = (node*)malloc(sizeof(node));
  nn->data = data;
  nn->left = nn->right=NULL;
  return nn;
}

node* insert(node *root,int data)
{
  if(root==NULL) root = getNode(data);
  else if(data<=root->data) root->left = insert(root->left, data);
  else root->right = insert(root->right, data);
  return root;
} 

// queue and stack  using  one linked list
typedef struct ListNode
{                        
  node * current_node;
  struct ListNode *next;
}listnode;

listnode* getListNode(node* curr)
{
  listnode* nn = (listnode*)malloc(sizeof(listnode));
  nn->current_node = curr;
  nn->next = NULL;
  return nn;
}

void enqueue(listnode** head,node *curr)
{
  if((*head)==NULL)
  {
    *head = getListNode(curr);
  }
  else{
    listnode *temp = (*head);
    while(temp->next!=NULL) temp = temp->next;
    temp->next = getListNode(curr);
  }
}

listnode* dequeue(listnode**head)
{
  listnode *temp = (*head);
  (*head)=(*head)->next;
   return temp;
}

void push(listnode **head,node *curr)
{
  listnode* nn = getListNode(curr);
  nn->next = (*head);
  (*head)=nn;
}

listnode* pop(listnode **head)
{
  return dequeue(head);
}

int isEmpty(listnode *head)
{
  return head==NULL?1:0;}
// end of stack and queue using same linked list

//2) display_level_in_reverse
void display_level_in_reverse(node *root)
{
  listnode* queue = getListNode(root);
  listnode* stack  = NULL;
  while(!isEmpty(queue))
  {
    listnode *front = dequeue(&queue);
    //listnode *left = 
    if (front->current_node->left!=NULL) {
      enqueue(&queue,front->current_node->left);}
  if (front->current_node->right!=NULL) {
      enqueue(&queue,front->current_node->right);
      }
    push(&stack,front->current_node);
  }
  while(!isEmpty(stack))
  {
    printf("%d , ",pop(&stack)->current_node->data);
  }
}

//1) display_level_order
void display_level_order(node *root)
{
  listnode* queue = getListNode(root);
  while(!isEmpty(queue))
  {
    listnode *front = dequeue(&queue);
    //listnode *left = 
    if (front->current_node->left!=NULL) {
      enqueue(&queue,front->current_node->left);}
  if (front->current_node->right!=NULL) {
      enqueue(&queue,front->current_node->right);
      }
    printf("%d , ",front->current_node->data);
  }
}
// 3) deepest node in  the binary tree
node* deepestNode(node* root)
{
  listnode* q = getListNode(root);
  node *ans = root;
  while(!isEmpty(q))
  {
    listnode* front = dequeue(&q);
    if(front->current_node->left!=NULL) 
      enqueue(&q,front->current_node->left);
    if(front->current_node->right!=NULL) 
      enqueue(&q,front->current_node->right);
      ans = front->current_node;
  }
  return ans;
}

//4) find minimum element in the binary tree
node *findmin(node*root)
{
  if(root->left==NULL) return root;
  return findmin(root->left);
} 

// 5) delete a Node in binary tree
node * delete(node* root,int data)
{
  if(root==NULL)
  {
    printf("there is No node like %d\nAre you Kidding Me?",data);
    return root;
  }
  else if(data<root->data) root->left = delete(root->left,data);
  else if(data>root->data) root->right = delete(root->right,data);
  else
  {
    // here data=root->data so this is the node to be deleted
    // Case 1 : no children
    if(root->left==NULL&&root->right==NULL)
    {
      node *temp = root;
      root=NULL;
      free(temp);
    }
    //case 2: one children may be left or right
    else if(root->left==NULL)
    {
      //no left child
      node *temp = root;
      root=root->right;
      free(temp);
    }
    else if(root->right==NULL)
    {
      //no right child
      node *temp = root;
      root = root->left;
      free(temp);
    }
    //case 3: root has two children
    /*
      find the minimum in right subtree 
      1) replace that value with current node tobe deleted
      2) delete that min value 
    */
    else
    {
      node* min = findmin(root->right);
      root->data = min->data;
      root->right = delete(root->right,root->data);
    }
  }
  return root;
}

// 6) no of leaf nodes in tree Without recursion
int leafCount(node* root)
{
  int count=0;
  listnode* q = NULL;
  enqueue(&q, root);
  while(!isEmpty(q))
  {
    listnode * front = dequeue(&q);
    if(front->current_node->left!=NULL)enqueue(&q,front->current_node->left);
    if(front->current_node->right!=NULL)enqueue(&q,front->current_node->right);
    if(front->current_node->right==NULL && front->current_node->left==NULL) count++;
  }
  return count;
}

// 7) no of half nodes in tree Without recursion
int halfCount(node* root)
{
  int count=0;
  listnode* q = NULL;
  enqueue(&q, root);
  while(!isEmpty(q))
  {
    listnode * front = dequeue(&q);
    if(front->current_node->left!=NULL)enqueue(&q,front->current_node->left);
    if(front->current_node->right!=NULL)enqueue(&q,front->current_node->right);

    if((front->current_node->right!=NULL && front->current_node->left==NULL)||((front->current_node->right==NULL && front->current_node->left!=NULL))) count++;
  }
  return count;
}
// 8)no of full nodes in a tree without recursion
int fullCount(node* root)
{
  int count=0;
  listnode* q = NULL;
  enqueue(&q, root);
  while(!isEmpty(q))
  {
    listnode * front = dequeue(&q);
    if(front->current_node->left!=NULL)enqueue(&q,front->current_node->left);
    if(front->current_node->right!=NULL)enqueue(&q,front->current_node->right);
    
    if(front->current_node->right!=NULL&&front->current_node->left!=NULL) count++;
  }
  return count;
}

//9) Maximum Sum level 
int maxSumLevel(node* root)
{
  listnode* q = getListNode(root);
  enqueue(&q, NULL);
  int level=1;
  int currsum=0,maxsum=0;
  int level_ans=0;
  while(!isEmpty(q))
  {
    node* temp = dequeue(&q)->current_node;
    if(temp==NULL)
    {
      if(currsum>maxsum) 
      {
        maxsum = currsum;
        level_ans=level;
        printf("\nat %d max sum is %d",level_ans,maxsum);
      }
      if(!isEmpty(q)) enqueue(&q, NULL);
      currsum=0;
      level++;
    }
    else
    {
      currsum+=temp->data;
      if(temp->left) enqueue(&q, temp->left);
      if(temp->right) enqueue(&q, temp->right);
    }
  }
  return level_ans;
}

// 10) print level order level by level
void printLevelByLevelNeetly(node* root)
{
  listnode* q = getListNode(root);
  enqueue(&q, NULL);
  while(!isEmpty(q))
  {
    node* front = dequeue(&q)->current_node;
    if(front==NULL)
    {
      printf("\n");
      if(!isEmpty(q)) enqueue(&q,NULL);
    }
    else
    {
      printf("%d , ",front->data);
      if(front->left) enqueue(&q, front->left);
      if(front->right) enqueue(&q, front->right);
    }
  }
}

//11)print out all its root-to-leaf paths 
void printWayToNode(node* root,int path[],int current);//declaration
int height(node* root);
void arraysToString(int arr[],int n);
void printAllWay(node *root)
{
  int path[height(root)];
  printWayToNode(root,path,0);
}

void printWayToNode(node* root,int path[],int current)
{
  path[current++] = root->data;
  if(root->left) printWayToNode(root->left,path,current);
  if(root->right) printWayToNode(root->right,path,current);
  if(!root->right&&!root->left)
  {
    arraysToString(path,current);
  }
}

//12) height of tree
int height(node* root)
{
  if(root==NULL) return 0;
  int leftHeight = height(root->left);
  int rightHeight = height(root->right);
  return (leftHeight>rightHeight?leftHeight:rightHeight)+1;
}


void arraysToString(int arr[],int n)
{
  for(int i=0;i<n;i++)
  {
    printf("%d ",arr[i]);
    if(i!=n-1) printf("->");
    else printf("\n");
  }
}

//13)Total Sum of all nodes 
int total_sum(node* root)
{
  if(root==NULL) return 0;
  return total_sum(root->left)+root->data+total_sum(root->right);
}

//14)Total Sum of all nodes without recursion
int sum_without_recursion(node* root)
{
  int ans=0;
  listnode* q = getListNode(root);
  while(!isEmpty(q))
  {
    node* front = dequeue(&q)->current_node;
    if(front->left) enqueue(&q,front->left);
    if(front->right) enqueue(&q,front->right);
    ans+=front->data;
  }
  return ans;
}
 
 //15) Convert tree to Its Mirror  
node* mirror(node* root)
{
  if(!root) return root;
  mirror(root->left);
  mirror(root->right);
  node* temp = root->left;
  root->left = root->right;
  root->right = temp;
  return root;
}

//16) Check trees are mirrors of each other/not
node* getMirror(node* root);
int isIdentical(node* root1,node* root2);
node* myStyleGetMirror(node *root);
int isMirrors(node* root1,node *root2)
{
  return isIdentical(root1, myStyleGetMirror(root2));
}

int isIdentical(node* root1,node* root2)
{
  if(root1==NULL && root2==NULL) return 1;
  else if (root1==NULL || root2==NULL) return 0;
  return root1->data==root2->data&& isIdentical(root1->left,root2->left) && isIdentical(root1->right, root2->right);
}

node* getMirror(node* root)
{
  if(root==NULL) return NULL;
  getMirror(root->left);
  getMirror(root->right);
  node* temp = root->left;
  root->left = root->right;
  root->right = temp;
  return  root;
}

//17) Mystyle of getMirror
node* myStyleGetMirror(node *root)
{
  if(root==NULL) return NULL;
  node* temp = root->right;
  root->right = myStyleGetMirror(root->left);
  root->left = myStyleGetMirror(temp);
  return root;
}

int main() 
{
  node *root = NULL;
  root = insert(root,5);
	root = insert(root,3);
	root = insert(root,2);
	root = insert(root,1);
	root = insert(root,4);
	root = insert(root,7);
	root = insert(root,6);
	root = insert(root,9);
	root = insert(root,8);
	root = insert(root,10);
  printf("\n 1)Level Order :");
  display_level_order(root);
  printf("\n 2)Reverse Level Order :");
  display_level_in_reverse(root);
  printf("\n 3)Deepest Node in The Tree is %d",deepestNode(root)->data);
  printf("\n 4)Min value in this tree: %d",findmin(root)->data);
  root = delete(root,10);
  printf("\n 5)Level Order after deletion of 10:");
  display_level_order(root);
  printf("\n 6)No of leaf nodes in the given tree:%d",leafCount(root));
  printf("\n 7)No of half nodes in the given tree:%d",halfCount(root));
  printf("\n 8)No of full nodes in the given tree:%d",fullCount(root));
  printf("\n 9) Maximum Sum level :%d",maxSumLevel(root));
  printf("\n 10) printing level by level neetly: \n");
  printLevelByLevelNeetly(root);
  printf("\n 11)print out all its root-to-leaf paths\n");
  printAllWay(root);
  printf("\n 12) max Height of Tree: %d",height(root));
  printf("\n 13) Total Sum of Tree : %d",total_sum(root));
  printf("\n 13) Total Sum of Tree without recursion : %d",sum_without_recursion(root));
  printf("\n 15) mirror of current tree :\n");
  printLevelByLevelNeetly(mirror(root));
  printf("\n 16) is Identical Mirrors Each other : %s",isMirrors(root,mirror(root))?"Yes":"No");
  return 0;
}

// to change rpl
