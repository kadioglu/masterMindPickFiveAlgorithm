package properProject;

/**
 * Interface to be used by codebreakers to guess a new code and get a key based on the code
 */

public interface CodeBreaker {
    Code guess();
    void receiveKey(Key key);
}
