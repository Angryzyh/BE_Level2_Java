package generic.json传输封装;

public class R<T> {
	private String code;
	private String msg;
	private T data;

	public R() {
		this.code = REnum.OK.getCode();
		this.msg = REnum.OK.getMsg();
	}

	public R(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public R(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static <T> R<T> ok() {
		return new R<>();
	}

	public static <T> R<T> ok(T data) {
		R<T> r = ok();
		r.setData(data);
		return r;
	}

	public static <T> R<T> fail() {
		return fail(REnum.UNKNOWN_ERROR.getCode(), REnum.UNKNOWN_ERROR.getMsg());
	}

	public static <T> R<T> fail(String msg) {
		return fail(REnum.UNKNOWN_ERROR.getCode(), msg);
	}

	public static <T> R<T> fail(String code, String msg) {
		return new R<>(code, msg);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}