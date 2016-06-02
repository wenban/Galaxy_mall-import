package galaxy.model;

public class KindEDResult {

	private int error;
	private String url;
	private String message;

	public KindEDResult(int error, String msg) {
		this.error = error;
		if (this.error == 0) {
			this.url = msg;
		}
		else {
			this.message = msg;
		}
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
