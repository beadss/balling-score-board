package player;

import frame.Frame;
import frame.FrameIssuer;
import frame.ball.Ball;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naver on 2018. 11. 26..
 */
public class Player {
	private final String name;
	private final List<Frame> frameList; // 10개
	private Frame currentFrame;
	private FrameIssuer frameIssuer;

	public Player(String name) {
		this.name = name;
		frameIssuer = new FrameIssuer();
		frameList = new ArrayList<>();

		addFrame();
	}

	public boolean addBall(Ball ball) {
		if(!currentFrame.addBall(ball)) {
			return addFrame();
		}

		return true;
	}

	public String getName() {
		return name;
	}

	public List<Frame> getFrameList() {
		return frameList;
	}

	private boolean addFrame() {
		Frame frame = frameIssuer.issue();

		if(frame != null) {
			frameList.add(frame);
			currentFrame = frame;

			return true;
		}

		return false;
	}
}
