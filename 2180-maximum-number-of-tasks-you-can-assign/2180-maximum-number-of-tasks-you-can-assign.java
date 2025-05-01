class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int numTasks = tasks.length;
        int numWorkers = workers.length;
        
        Arrays.sort(tasks);
        Arrays.sort(workers);
        
        int minTasksToTry = 1;
        int maxTasksToTry = Math.min(numWorkers, numTasks);
        int maxCompletableTasks = 0;
        
        while (minTasksToTry <= maxTasksToTry) {
            int tasksToTry = (minTasksToTry + maxTasksToTry) / 2;
            
            if (canCompleteTasks(tasks, workers, pills, strength, tasksToTry)) {
                maxCompletableTasks = tasksToTry;
                minTasksToTry = tasksToTry + 1;
            } else {
                maxTasksToTry = tasksToTry - 1;
            }
        }
        
        return maxCompletableTasks;
    }
    
    private boolean canCompleteTasks(int[] tasks, int[] workers, int pillsAvailable, int pillStrength, int tasksToComplete) {
        int remainingPills = pillsAvailable;
        int numWorkers = workers.length;
        
        Deque<Integer> availableWorkers = new ArrayDeque<>();
        int workerIndex = numWorkers - 1;
        
        for (int taskIndex = tasksToComplete - 1; taskIndex >= 0; taskIndex--) {
            int currentTask = tasks[taskIndex];
            
            while (workerIndex >= numWorkers - tasksToComplete && 
                   workers[workerIndex] + pillStrength >= currentTask) {
                availableWorkers.addFirst(workers[workerIndex]);
                workerIndex--;
            }
            
            if (availableWorkers.isEmpty()) {
                return false;
            } else if (availableWorkers.getLast() >= currentTask) {
                availableWorkers.pollLast();
            } else {
                if (remainingPills == 0) {
                    return false;
                }
                remainingPills--;
                availableWorkers.pollFirst();
            }
        }
        
        return true;
    }
}