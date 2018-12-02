package bowling.player;

import bowling.frame.Frame;
import bowling.frame.FrameIssuer;

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

	public boolean addBall(int pinCount) {
		if(!currentFrame.addBall(pinCount)) {
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
