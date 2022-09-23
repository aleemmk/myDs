/**
 car fleet is the group of cars to gether reached destination.
*/
  class Car{
        int position;
        double timetoTarget;
        
        Car (int position ,double timetoTarget){
            this.position = position;
            this.timetoTarget = timetoTarget;
        }
        
    }

class Solution {
    
  
    
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        
        if(n==0) return 0;
        Car [] cars = new Car [n];
        
        for(int i=0;i<n;i++){
            
            cars[i] = new Car(position[i],((target-position[i])*1.0)/speed[i]);
        }
        
        Arrays.sort(cars,new Comparator<Car>(){
            public int compare(Car a,Car b){
                return a.position-b.position;
            }
        });
        
        int ans = 0;
        
        for(int i=n-1;i>=1;i--){
            
            if(cars[i].timetoTarget >= cars[i-1].timetoTarget){   
                cars[i-1] = cars[i];  // transfer the prop of  i th car to i-1 as now both moving with same speed;
            }else{
                ans++;
            }
        }
        return ans+1;
    }
}