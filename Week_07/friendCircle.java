class Solution {
    class UnionFind{
            private int count;
            private int[] parents;
            public UnionFind(int n){
                count = n;
                parents = new int[count];
                for(int i=0;i<count;i++){
                    parents[i] = i;
                }
            }

            public int Find(int p){
                while(p != parents[p]){
                    parents[p] = parents[parents[p]];
                    p = parents[p];
                }
                return p;
            }

            public void Union(int p, int q){
                int rootP = Find(p);
                int rootQ = Find(q);
                if(rootP == rootQ) return;
                else{
                    parents[rootP] = rootQ;
                }
                count--;

                }

            public int count(){
                return count;
            }
            }
    public int findCircleNum(int[][] M) {
            int len = M.length;
            UnionFind uf = new UnionFind(len);
            //int n = M[]
            for(int i = 0; i < len;i++){
                for(int j = 0; j < len;j++){
                    if(M[i][j]==1){
                        uf.Union(i,j);
                    }
                }
            }

            return uf.count();

        }
    }

