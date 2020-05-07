package properProject;

/**
 * Creates a CodeBreaker interface
 * All CodeBreakers are used to get input for the game
 */

public interface CodeBreaker {
    Code guess();
    void receiveKey(Key key);
}
