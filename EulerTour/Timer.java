package eulergraph;


/** Timer class for roughly calculating running time of programs
 * @author : Panchami Rudrakshi
 *  Corrected memory calculations to 1048576 instead of 1000000
 */

public class Timer {
    long startTime, endTime, elapsedTime, memAvailable, memUsed;

    Timer() {
	startTime = System.currentTimeMillis();
    }

    public void start() {
	startTime = System.currentTimeMillis();
    }

    public Timer end() {
	endTime = System.currentTimeMillis();
	elapsedTime = endTime-startTime;
	memAvailable = Runtime.getRuntime().totalMemory();
	memUsed = memAvailable - Runtime.getRuntime().freeMemory();
	return this;
    }

    public String toString() {
        return "Time: " + elapsedTime + " msec.\n" + "Memory: " + (memUsed/1048576) + " MB / " + (memAvailable/1048576) + " MB.";
    }

}


