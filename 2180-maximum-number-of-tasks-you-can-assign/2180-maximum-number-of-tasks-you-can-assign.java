class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int numTasks = tasks.length;
        int numWorkers = workers.length;
        
        Arrays.sort(tasks);     
        Arrays.sort(workers);  
        
        int left = 0;
        int right = Math.min(numTasks, numWorkers);
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canCompleteTasksWithWorkers(tasks, workers, pills, strength, mid, numWorkers - mid)) {
                left = mid + 1;  
            } else {
                right = mid - 1; 
            }
        }
        
        return right;
    }
    
    
    private boolean canCompleteTasksWithWorkers(int[] tasks, int[] workers, int pillsRemaining, 
                                             int pillStrength, int numTasksToComplete, int startWorkerIndex) {
        
        int[] taskQueue = new int[numTasksToComplete];
        int queueWritePos = 0;  
        int queueReadPos = 0;   
        
        int taskIndex = 0;
        
        for (int workerIndex = 0; workerIndex < numTasksToComplete; workerIndex++) {
            int currentWorkerStrength = workers[startWorkerIndex + workerIndex];
            
            if (queueReadPos == queueWritePos) {
                
                if (currentWorkerStrength >= tasks[taskIndex]) {
                    taskIndex++;
                    continue;
                }
                
                if (pillsRemaining == 0) {
                    return false; 
                }
                
                currentWorkerStrength += pillStrength;
                pillsRemaining--;
                
                while (taskIndex < numTasksToComplete && currentWorkerStrength >= tasks[taskIndex]) {
                    taskQueue[queueWritePos++] = tasks[taskIndex++];
                }
                
                if (queueReadPos == queueWritePos) {
                    return false;
                }
                
                queueWritePos--;
                
            } else {
                
                if (currentWorkerStrength >= taskQueue[queueReadPos]) {
                    queueReadPos++;
                    continue;
                }
                
                if (pillsRemaining == 0) {
                    return false; 
                }
                
                currentWorkerStrength += pillStrength;
                pillsRemaining--;
                
                while (taskIndex < numTasksToComplete && currentWorkerStrength >= tasks[taskIndex]) {
                    taskQueue[queueWritePos++] = tasks[taskIndex++];
                }
                
                queueWritePos--;
            }
        }
        
        return queueReadPos == queueWritePos;
    }
}