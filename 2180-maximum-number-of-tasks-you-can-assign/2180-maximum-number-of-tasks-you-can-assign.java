import java.util.*;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);  
        Arrays.sort(workers); 
        
        int left = 0, right = Math.min(tasks.length, workers.length);
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                ans = mid;
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int k) {
        int[] selectedTasks = Arrays.copyOf(tasks, k);
        
        int[] selectedWorkers = new int[k];
        for (int i = 0; i < k; i++) {
            selectedWorkers[i] = workers[workers.length - k + i];
        }
        
        TreeMap<Integer, Integer> availableWorkers = new TreeMap<>();
        for (int worker : selectedWorkers) {
            availableWorkers.put(worker, availableWorkers.getOrDefault(worker, 0) + 1);
        }
        
        for (int i = k - 1; i >= 0; i--) {
            int task = selectedTasks[i];
            
            Integer strongEnoughWorker = availableWorkers.ceilingKey(task);
            if (strongEnoughWorker != null) {
                decrementOrRemove(availableWorkers, strongEnoughWorker);
            } else if (pills > 0) {
                Integer potentialWorker = availableWorkers.ceilingKey(task - strength);
                if (potentialWorker != null) {
                    decrementOrRemove(availableWorkers, potentialWorker);
                    pills--;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    private void decrementOrRemove(TreeMap<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }
}