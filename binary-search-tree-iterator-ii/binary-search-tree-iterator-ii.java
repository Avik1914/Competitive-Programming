            TreeNode newRoot=popped.right;
            while(newRoot!=null){
                mainStack.push(newRoot);
                newRoot=newRoot.left;
            }
        }
        else{
            prev--;
        }
        auxStack.push(popped);
        return popped.val;
    }
    
    public boolean hasPrev() {
        return auxStack.size()>=2;
    }
    
    public int prev() {
         TreeNode popped=auxStack.pop();
         prev++;
         mainStack.push(popped);
         return auxStack.peek().val;
    }
}
​
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */
