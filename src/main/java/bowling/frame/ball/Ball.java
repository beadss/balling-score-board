package bowling.frame.ball;

/**
 * Created by naver on 2018. 11. 26..
 */
public class Ball {
	public static final int MAX_PIN_COUNT = 10;

	private final int pinCount;
	private BallStatus ballStatus;

	public Ball(int pinCount, BallStatus ballStatus) {
		if(pinCount > MAX_PIN_COUNT) {
			throw new IllegalArgumentException("over max pin count");
		}
		this.pinCount = pinCount;
		this.ballStatus = ballStatus;
	}

	public int getPinCount() {
		return pinCount;
	}

	public BallStatus getBallStatus() {
		return ballStatus;
	}
}