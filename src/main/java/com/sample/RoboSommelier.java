package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import javax.swing.JOptionPane;

public class RoboSommelier {

    public static final void main(String[] args) {
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Question {

        public String question;
        public String answer;
        public String[] options;


        public Question(String _question, String[] _options) {
            this.question = _question;
            this.options = _options;
            this.answer = null;
        }

        public void displayQuestion() {
            int n = JOptionPane.showOptionDialog(null,
                    question, "Answer here",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
            answer = options[n];
        }

    }

    public static class Choice {
        public String my_choice;

        public Choice(String c) {
            this.my_choice = c;
            JOptionPane.showMessageDialog(null, c);
        }
    }


}
