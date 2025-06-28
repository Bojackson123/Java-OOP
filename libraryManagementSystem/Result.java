package libraryManagementSystem;

public class Result<T> {
    private T value;
    private String error;
    private boolean success;

    // Success constructor
    public Result(T value) {
        this.value = value;
        this.success = true;
    }

    // Error constructor
    public Result(String errorMessage) {
        this.error = errorMessage;
        this.success = false;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getValue() {
        return value;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return success ? "Success: " + value : "Error: " + error;
    }
}