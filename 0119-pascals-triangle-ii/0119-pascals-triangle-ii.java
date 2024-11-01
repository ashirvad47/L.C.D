class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);  // Initialize the first row with [1]
        
        // Loop to build each row up to the target rowIndex
        for (int i = 1; i <= rowIndex; i++) {
            // Update each element from the end to the beginning of the row
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            // Append 1 to the end to complete the current row
            row.add(1);
        }
        
        return row;
    }
}

/*
Explanation:

1. **Initialize the Row**:
   - We start with an empty list called `row` and add the first element `1` to represent the first row (Row 0 in Pascal’s triangle): `row = [1]`.

2. **Outer Loop (Row Building)**:
   - The outer loop runs from `i = 1` to `i = rowIndex`. For each iteration, `i` represents the current row being built.

3. **Inner Loop (Updating Values)**:
   - The inner loop runs from `j = i - 1` down to `1`, updating each element in the row from the end towards the beginning. 
   - Each `row[j]` is updated with the sum of `row[j]` and `row[j - 1]`, which follows Pascal’s triangle rule. 
   - Updating backwards prevents overwriting values that are still needed for calculations.

4. **Adding the Last Element**:
   - After the inner loop finishes, we add `1` to the end of the list with `row.add(1);`. This completes the row by ensuring both ends have `1`s.

5. **Return the Row**:
   - After building the row for the specified `rowIndex`, we return `row`, which now contains the values for that row in Pascal’s triangle.

Key Points:
- This approach uses **O(rowIndex)** space by modifying a single row in place.
- Updating from the end of the row backward ensures values aren’t overwritten.
*/
