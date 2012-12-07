package GUI;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameListener extends Component {
	FrameListener(){
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me){
				System.out.println(me);
			}
		});
	}
}

