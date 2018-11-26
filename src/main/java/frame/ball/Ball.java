package frame.ball;

/**
 * Created by naver on 2018. 11. 26..
 */
public class Ball {
	private static final int MAX_PIN_COUNT = 10;

	private final int pinCount;
	private BallStatus ballStatus;

	public Ball(int pinCount) {
		if(pinCount > MAX_PIN_COUNT) {
			throw new IllegalArgumentException("over max pin count");
		}
		this.pinCount = pinCount;
		ballStatus = BallStatus.NONE;
	}

	public int getPinCount() {
		return pinCount;
	}

	public BallStatus getBallStatus() {
		return ballStatus;
	}

	public void setBallStatus(Ball beforeBall) {
		if(ballStatus != BallStatus.NONE) {
			return;
		}

		computeBallStatus(beforeBall);
	}

	private void setBallStatus(BallStatus ballStatus) {
		this.ballStatus = ballStatus;
	}

	private void computeBallStatus(Ball beforeBall) {

		if(beforeBall.getPinCount() == MAX_PIN_COUNT) {
			beforeBall.setBallStatus(BallStatus.STRIKE);
			if(pinCount == MAX_PIN_COUNT) {
				this.setBallStatus(BallStatus.STRIKE);
			}
		} else if((beforeBall.getPinCount() + getPinCount()) == MAX_PIN_COUNT) {
			this.setBallStatus(BallStatus.SPARE);
		} else {
			this.setBallStatus(BallStatus.OPEN_FRAME);
		}
	}
}