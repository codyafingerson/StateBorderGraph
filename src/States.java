// Dr. Maryann Cummings gave me the idea for this portion of code and I have modified it to suit my needs

/**
 * Data class that holds the name of states and their respective hash value
 * @author Cody Fingerson
 */
public class States {
    private int n; // the number of states in the states array
    private int m; // The current size of the array
    private String[] states;  // Array of names of states

    /**
     * Create a new state
     * @param capacity the number of states
     */
    public States(int capacity) {
        m = capacity;
        n = 0;
        states = new String[m];
    }

    /**
     * Add a state to the array
     * @param str the name of the state
     * @return the hash value of the state that was added
     */
    // This method was originally in LinearProbingHashST.java in Algorithms 4th edition by Sedgewick & Wayne
    // I have modified it to suit the needs of this program
    public int add(String str){
        int i;
        // Set i to the hash of the incoming string
        // Ensure it is not null and can not equal null
        for (i = hash(str); states[i] != null; i = (i + 1) % m) {
            // If states[i] is equal to the added state, return the hash value of the state
            if (states[i].equals(str)) {
                return i;
            }
        }
        states[i] = str;
        n++;
        return i;
    }

    /**
     * Returns the name of the state at the specified index
     * @param ind the index
     * @return the name of the state
     */
    public String get(int ind) {
        return states[ind];
    }

    /**
     * Obtain the hash value for a specified string
     * @param s the string
     * @return the hash value of the string
     */
    private int hash(String s) {
        // Hash and format the hash using hexadecimal and modulo by the current size of the array
        int x = (s.hashCode() & 0x7fffffff) % m;
        // System.out.println(x);
        return x; // the hash value of the state
    }
}

