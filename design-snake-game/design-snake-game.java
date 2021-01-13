        map.put("L",new int[]{0,-1});
        
        w=width;
        h=height;
        f=food;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] val=map.get(direction);
        x=x+val[0];
        y=y+val[1];
        
        String str=x+","+y;
        if(x<0 || x>=h || y<0 || y>=w){
            return -1;
        }
        if(cnt>=f.length || x!=f[cnt][0] || y!=f[cnt][1]){
            int[] pop=queue.poll();
            set.remove((pop[0]+","+pop[1]));
        }else{
            cnt++;
        }
        if(set.contains(str))
            return -1;
        queue.add(new int[]{x,y});
        set.add(str);
        return queue.size()-1;
    }
}
​
/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
