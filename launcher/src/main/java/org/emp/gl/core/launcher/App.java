package org.emp.gl.core.launcher;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.gui.ButtonViewer;
import org.emp.gl.gui.WatchViewer;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hello world!
 *
 */
public class App {

    static {
        Lookup.getInstance().register(TimerService.class, new DummyTimeServiceImpl());
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WatchViewer w1 = new WatchViewer();
                w1.setVisible(true);
                //Lookup.getInstance().registremontre(w1);

                w1.setLocation(200, 100);
                WatchViewer w2 = new WatchViewer();

                w2.setVisible(true);
                w2.setLocation(600, 100);

                ButtonViewer But = new ButtonViewer();
                But.setVisible(true);
                But.changeState(w1);
                But.getjButton1().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Lookup.getInstance().notifyMontre();
                        But.getStates().Click(But);
                    }
                });
                But.getjButton2().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (But.getStates() == w1){
                            But.changeState(w2);
                        }else {
                            But.changeState(w1);
                        }
                    }
                });
            }
        });
    }

}
