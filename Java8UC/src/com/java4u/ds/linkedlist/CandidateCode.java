/**
 * 
 */
package com.java4u.ds.linkedlist;

/**
 * @author Bharath
 *
 */
import java.io.*;
import java.util.LinkedList;
public class CandidateCode 
{ 

	public int[][] array;

    boolean flag=true;
    int[][] a;
    int R;
    int C;
    int MAX=2147483647;
    LinkedList l = new LinkedList();


    void initialize() {
        R=array.length;
        C=array[0].length;
        a=new int[R][C];

        for(int i=0;i<R && flag;i++) {
            for(int j=0;j<C && flag;j++) {
                if(array[i][j]==-1) {
                    flag=false;
                }
            }
        }
    }

    void process() {
        int p=0,q=0;
        for(int i=R-1;i>=0;i--) {
            for(int j=C-1;j>=0;j--){
                if(array[i][j]==-1) {
                    p=i;
                    q=j;
                    array[i][j]=0;
                }
                a[i][j]=MAX;
            }
        }
        l.add(p);
        l.add(q);
        a[p][q]=0;
    }

    void solve() {
        int p=0,q=0;
        while(l.size()>0) {
            p=(Integer)l.removeFirst();
            q=(Integer)l.removeFirst();

            for(int i=p-1;i<=p+1;i++) {
                for(int j=q-1;j<=q+1;j++){
                    if(i>=0 && j>=0 && i<R && j<C && a[i][j]>a[p][q]+array[i][j]) {
                        a[i][j]=a[p][q]+array[i][j];
                        l.add(i);
                        l.add(j);
                    }
                }
            }
        }
    }

    public  int minimumcost() {
        initialize();

        if(flag)
            return 0;

        process();
        solve();

        MAX=0;
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++){
                if(array[i][j]==0 && a[i][j]>MAX)
                    MAX=a[i][j];
            }
        }

        return MAX;
    }
    
    public static void main(String args[]){
    	CandidateCode code = new CandidateCode();
    	int [][] array = {{-1,10,-1},{10,-1,10},{-1,10,-1}};
    	code.array = array;
    	int max = code.minimumcost();
    	System.out.println(max);
    	
    }
}