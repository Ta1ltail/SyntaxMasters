package com.mycompany.jframe_syntaxmasters;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JFrame_GameMenu extends javax.swing.JFrame {

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    GraphicsConfiguration gc = gd.getDefaultConfiguration();

    String quizType = "";

    public String[] levelBackgroundImages = {
        "/Icons/409097-final.gif",
        "/Icons/223e6792880429.5e569ff84ebef.gif",
        "/Icons/221837-ezgif.com-resize.gif",
        "/Icons/3e4c9d81ba6be013081a1506dd7fcdec-ezgif.com-resize.gif",
        "/Icons/fEDDyGt-ezgif.com-resize.gif"
    };

    // ===== JAVA QUESTIONS =====
    public String[][] jvquestions = {
        {
            "What is the output of: int a = 5; System.out.println(a++);",
            "What is 2 + 2?",
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "What is the largest ocean on Earth?"
        },
        {
            "What is 5 * 5?",
            "Which is the smallest planet?",
            "What is the speed of light in m/s (approx)?",
            "What is 12 + 15?",
            "Which metal is liquid at room temperature?"
        },
        {
            "What is the square root of 144?",
            "Who wrote 'Hamlet'?",
            "What is the freezing point of water in Fahrenheit?",
            "What is the chemical symbol for Sodium?",
            "Solve: 3x + 5 = 14. Find x."
        },
        {
            "What is the value of Pi (approx)?",
            "What is the derivative of x^2?",
            "What is the boiling point of water in Celsius?",
            "Who painted the Mona Lisa?",
            "What is the binary equivalent of decimal 10?"
        },
        {
            "Solve: 2x + 3 = 9. Find x.",
            "What is the atomic number of Carbon?",
            "Which planet has the most moons?",
            "What is the largest desert on Earth?",
            "What is the Pythagorean theorem formula?"
        }
    };

    public String[][][] jvanswerOptions = {
        {
            {"5", "6", "4", "Compile Error"},
            {"3", "4", "5", "22"},
            {"Berlin", "Paris", "London", "Madrid"},
            {"Earth", "Mars", "Jupiter", "Venus"},
            {"Atlantic", "Indian", "Arctic", "Pacific"}
        },
        {
            {"20", "25", "30", "35"},
            {"Mercury", "Venus", "Earth", "Mars"},
            {"3x10^8", "2x10^8", "1x10^8", "None"},
            {"27", "28", "29", "30"},
            {"Mercury", "Gold", "Silver", "Iron"}
        },
        {
            {"10", "11", "12", "13"},
            {"Shakespeare", "Dickens", "Austen", "Hemingway"},
            {"32", "0", "-32", "100"},
            {"Na", "N", "S", "H"},
            {"3", "2", "4", "1"}
        },
        {
            {"3.14", "3.15", "3.16", "3.17"},
            {"x", "2x", "x^2", "1"},
            {"100", "0", "212", "37"},
            {"Da Vinci", "Van Gogh", "Picasso", "Rembrandt"},
            {"1010", "1100", "1110", "1001"}
        },
        {
            {"3", "2", "4", "1"},
            {"6", "8", "12", "14"},
            {"Jupiter", "Saturn", "Mars", "Neptune"},
            {"Sahara", "Arctic", "Gobi", "Kalahari"},
            {"a^2 + b^2 = c^2", "a + b = c", "a * b = c", "a/b = c"}
        }
    };

    public int[][] jvcorrectAnswers = {
        {0, 1, 1, 1, 3},
        {1, 0, 0, 0, 0},
        {2, 0, 0, 0, 0},
        {0, 1, 2, 0, 0},
        {0, 0, 1, 0, 0}
    };

    // ===== PYTHON QUESTIONS =====
    public String[][] pyquestions = {
        {
            "What is the output of: print(2 ** 3)?",
            "What is 2 + 2?",
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "What is the largest ocean on Earth?"
        },
        {
            "What is 5 * 5?",
            "Which is the smallest planet?",
            "What is the speed of light in m/s (approx)?",
            "What is 12 + 15?",
            "Which metal is liquid at room temperature?"
        },
        {
            "What is the square root of 144?",
            "Who wrote 'Hamlet'?",
            "What is the freezing point of water in Fahrenheit?",
            "What is the chemical symbol for Sodium?",
            "Solve: 3x + 5 = 14. Find x."
        },
        {
            "What is the value of Pi (approx)?",
            "What is the derivative of x^2?",
            "What is the boiling point of water in Celsius?",
            "Who painted the Mona Lisa?",
            "What is the binary equivalent of decimal 10?"
        },
        {
            "Solve: 2x + 3 = 9. Find x.",
            "What is the atomic number of Carbon?",
            "Which planet has the most moons?",
            "What is the largest desert on Earth?",
            "What is the Pythagorean theorem formula?"
        }
    };

    public String[][][] pyanswerOptions = {
        {
            {"6", "8", "5", "Error"},
            {"3", "4", "5", "22"},
            {"Berlin", "Paris", "London", "Madrid"},
            {"Earth", "Mars", "Jupiter", "Venus"},
            {"Atlantic", "Indian", "Arctic", "Pacific"}
        },
        {
            {"20", "25", "30", "35"},
            {"Mercury", "Venus", "Earth", "Mars"},
            {"3x10^8", "2x10^8", "1x10^8", "None"},
            {"27", "28", "29", "30"},
            {"Mercury", "Gold", "Silver", "Iron"}
        },
        {
            {"10", "11", "12", "13"},
            {"Shakespeare", "Dickens", "Austen", "Hemingway"},
            {"32", "0", "-32", "100"},
            {"Na", "N", "S", "H"},
            {"3", "2", "4", "1"}
        },
        {
            {"3.14", "3.15", "3.16", "3.17"},
            {"x", "2x", "x^2", "1"},
            {"100", "0", "212", "37"},
            {"Da Vinci", "Van Gogh", "Picasso", "Rembrandt"},
            {"1010", "1100", "1110", "1001"}
        },
        {
            {"3", "2", "4", "1"},
            {"6", "8", "12", "14"},
            {"Jupiter", "Saturn", "Mars", "Neptune"},
            {"Sahara", "Arctic", "Gobi", "Kalahari"},
            {"a^2 + b^2 = c^2", "a + b = c", "a * b = c", "a/b = c"}
        }
    };

    public int[][] pycorrectAnswers = {
        {1, 1, 1, 1, 3},
        {1, 0, 0, 0, 0},
        {2, 0, 0, 0, 0},
        {0, 1, 2, 0, 0},
        {0, 0, 1, 0, 0}
    };

    public int currentLevel = 0;
    public int currentQuestionIndex = 0;
    public String inputText;
    public int correctAnswersCount = 0;
    public int wrongAnswersCount = 0;

    public JFrame_GameMenu(JFrame_HomePage homePage, String inputText, String selectedLevel, String quizType) {
        this.quizType = quizType;
        this.inputText = inputText;
        this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        initComponents();
        jLabel2.setText("Welcome Back \" " + inputText + " \"");
        currentLevel = 0;
        currentQuestionIndex = 0;
        correctAnswersCount = 0;
        wrongAnswersCount = 0;
        hideQuizDisplay();
        jLabel10.setText("LEVEL: ");
        jButton6.setText("Start Game");
        jButton8.setVisible(false);
        jButton6.addActionListener(evt -> startLevelTransition());
        typeOfQuiz();
        updateLevelBackground();
    }

    private void typeOfQuiz() {
        if ("java".equals(quizType)) {
            ImageIcon javaIcon = new ImageIcon(getClass().getResource("/Icons/java (2).png"));
            jLabel11.setIcon(javaIcon);
            jLabel11.setText("");
        } else if ("python".equals(quizType)) {
            ImageIcon pythonIcon = new ImageIcon(getClass().getResource("/Icons/python.png"));
            jLabel11.setIcon(pythonIcon);
            jLabel11.setText("");
        } else {
            jLabel11.setText("Unknown");
        }
    }

    public void playButtonSound() {
        if (JFrame_HomeMenu.isButtonSoundEnabled) {
            try {
                URL soundURL = getClass().getResource("/Sound/sounds-of-button-selection-in-the-game-menu-sound-effect-ynsbl-cek1c_44Nf2YCe.wav");

                if (soundURL != null) {
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
                    Clip buttonClip = AudioSystem.getClip();
                    buttonClip.open(audioStream);
                    buttonClip.start();
                } else {
                    System.err.println("Button sound file not found!");
                }
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }

    private void hideQuizDisplay() {
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel3.setVisible(false);
        jLabel10.setText("");
    }

    public void enableButtons() {
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
    }

    private void updateLevelBackground() {
        String imagePath = levelBackgroundImages[currentLevel];
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource(imagePath));
        jLabel1.setIcon(backgroundIcon);
    }

    private void startLevelTransition() {

        jPanel5.setVisible(true);
        jPanel5.setSize(50, 50);

        jPanel5.setBorder(new BevelBorder(BevelBorder.RAISED,
                new Color(255, 0, 0),
                new Color(204, 0, 102),
                new Color(153, 0, 255),
                new Color(51, 0, 153)
        ));
        jPanel5.setOpaque(true);
        jPanel5.setEnabled(true);
        jPanel5.setLayout(null);

        final int startWidth = 50;
        final int startHeight = 50;
        final int targetWidth = 720;
        final int targetHeight = 370;

        boolean showResult = jButton6.getText().equals("Show Result");

        Timer sizeAnimationTimer = new Timer(10, new ActionListener() {
            private int width = startWidth;
            private int height = startHeight;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (width < targetWidth || height < targetHeight) {
                    if (width < targetWidth) width += 10;
                    if (height < targetHeight) height += 10;
                    jPanel5.setSize(width, height);
                    jPanel5.repaint();
                } else {
                    ((Timer) e.getSource()).stop();
                    if (showResult) {
                        showFinalResults();
                    } else {
                        startCountdown();
                    }
                }
            }
        });

        sizeAnimationTimer.start();
    }

    private void showFinalResults() {
        jLabel12.setVisible(true);
        jLabel14.setVisible(true);
        jLabel15.setVisible(true);
        jLabel18.setVisible(true);
        jLabel16.setVisible(true);
        jLabel17.setVisible(true);
        jLabel13.setVisible(true);

        jLabel12.setText("Player: " + inputText);
        jLabel18.setText("Quiz Type: " + quizType);
        jLabel16.setText("Correct Answers: " + correctAnswersCount);
        jLabel17.setText("Wrong Answers: " + wrongAnswersCount);
        jLabel15.setText("Congratulations, you finished the game!");

        double accuracy = calculateAccuracy(correctAnswersCount, wrongAnswersCount);
        jLabel13.setText("Accuracy: " + String.format("%.2f", accuracy) + "%");

        String title;
        if (correctAnswersCount <= 10) {
            title = "Beginner Level";
        } else if (correctAnswersCount <= 15) {
            title = "Intermediate Level";
        } else if (correctAnswersCount <= 20) {
            title = "Expert Level";
        } else {
            title = "Master Level";
        }

        jLabel14.setText("Title Earned: " + title);
        JOptionPane.showMessageDialog(this, "Title Earned: " + title);

        jButton8.setVisible(true);
    }

    private void levelComplete() {
        jButton6.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);

        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);

        Timer closeAnimationTimer = new Timer(10, new ActionListener() {
            private int width = jPanel5.getWidth();
            private int height = jPanel5.getHeight();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (width > 50 || height > 50) {
                    if (width > 50) width -= 10;
                    if (height > 50) height -= 10;
                    jPanel5.setSize(width, height);
                } else {
                    ((Timer) e.getSource()).stop();

                    jPanel5.setVisible(false);

                    if (currentLevel < levelBackgroundImages.length - 1) {
                        currentLevel++;
                        updateLevelBackground();
                        jButton6.setText("Go to Next Level");
                        jButton6.setVisible(true);
                    } else {
                        jButton6.setText("Show Result");
                        jButton6.setVisible(true);
                    }

                    jButton6.setEnabled(true);
                }
            }
        });
        closeAnimationTimer.start();
    }

    private void startCountdown() {
        jLabel3.setVisible(true);
        jLabel3.setText("3");

        Timer countdownTimer = new Timer(1000, new ActionListener() {
            private int count = 3;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count > 0) {
                    jLabel3.setText(String.valueOf(count));
                    count--;
                } else {
                    jLabel3.setText("Go!");
                    ((Timer) e.getSource()).stop();

                    Timer delayTimer = new Timer(700, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jLabel3.setVisible(false);
                            jLabel10.setText("Level: " + (currentLevel + 1));
                            displayQuestion();
                            ((Timer) e.getSource()).stop();
                        }
                    });
                    delayTimer.start();
                }
            }
        });

        countdownTimer.start();
    }

    private void displayQuestion() {
        String[][] questions = "java".equals(quizType) ? jvquestions : pyquestions;
        String[][][] answerOptions = "java".equals(quizType) ? jvanswerOptions : pyanswerOptions;

        if (currentLevel < questions.length && currentQuestionIndex < questions[currentLevel].length) {
            jLabel6.setText("<html><div style='width:600px;'>" + questions[currentLevel][currentQuestionIndex] + "</div></html>");
            jLabel4.setIcon(null);
            jLabel4.setText("");

            jLabel5.setText("a) " + answerOptions[currentLevel][currentQuestionIndex][0]);
            jLabel7.setText("b) " + answerOptions[currentLevel][currentQuestionIndex][1]);
            jLabel9.setText("c) " + answerOptions[currentLevel][currentQuestionIndex][2]);
            jLabel8.setText("d) " + answerOptions[currentLevel][currentQuestionIndex][3]);

            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);

            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
        } else {
            levelComplete();
        }
    }

    private void checkAnswer(int selectedIndex) {
        int[][] correctAnswers = "java".equals(quizType) ? jvcorrectAnswers : pycorrectAnswers;
        String[][] questions = "java".equals(quizType) ? jvquestions : pyquestions;

        if (selectedIndex == correctAnswers[currentLevel][currentQuestionIndex]) {
            correctAnswersCount++;
        } else {
            wrongAnswersCount++;
        }

        currentQuestionIndex++;

        if (currentQuestionIndex >= questions[currentLevel].length) {
            levelComplete();
        } else {
            displayQuestion();
        }
    }

    private double calculateAccuracy(int correctAnswers, int wrongAnswers) {
        int totalQuestions = correctAnswers + wrongAnswers;
        if (totalQuestions == 0) return 0;
        return ((double) correctAnswers / totalQuestions) * 100;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(30, 30, 30));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel3.setPreferredSize(new java.awt.Dimension(1401, 15));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1397, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel6, java.awt.BorderLayout.LINE_START);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.MatteBorder(null), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jButton5.setText("EXIT");
        jButton5.setEnabled(false);
        jButton5.addActionListener(evt -> jButton5ActionPerformed(evt));

        jButton7.setText("Settings");
        jButton7.addActionListener(evt -> jButton7ActionPerformed(evt));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(490, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jButton1.setText("A");
        jButton1.setEnabled(false);
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        jButton2.setText("B");
        jButton2.setEnabled(false);
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));

        jButton3.setText("C");
        jButton3.setEnabled(false);
        jButton3.addActionListener(evt -> jButton3ActionPerformed(evt));

        jButton4.setText("D");
        jButton4.setEnabled(false);
        jButton4.addActionListener(evt -> jButton4ActionPerformed(evt));

        jPanel7.setBackground(new java.awt.Color(23, 23, 23));
        jPanel7.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 0, 24));
        jLabel2.setForeground(new java.awt.Color(51, 255, 0));
        jLabel2.setText("WELCOME BACK \"            \"");

        jLabel10.setFont(new java.awt.Font("OCR A Extended", 0, 24));
        jLabel10.setForeground(new java.awt.Color(51, 255, 0));
        jLabel10.setText("Level: ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("OCR A Extended", 1, 14));
        jLabel11.setForeground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jButton1)
                .addGap(80, 80, 80)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(116, 116, 116)
                .addComponent(jButton4)
                .addGap(64, 64, 64)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.MatteBorder(null), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel2.setPreferredSize(new java.awt.Dimension(112, 669));
        jPanel2.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(720, 370));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 65));
        jLabel3.setForeground(new java.awt.Color(0, 255, 0));
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 145, 122));

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 0, 18));
        jLabel4.setForeground(new java.awt.Color(51, 255, 51));
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 570, 200));

        jLabel5.setFont(new java.awt.Font("OCR A Extended", 1, 16));
        jLabel5.setForeground(new java.awt.Color(51, 255, 51));
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 300, 40));

        jLabel6.setFont(new java.awt.Font("OCR A Extended", 0, 22));
        jLabel6.setForeground(new java.awt.Color(51, 255, 51));
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 700, 60));

        jLabel7.setFont(new java.awt.Font("OCR A Extended", 1, 16));
        jLabel7.setForeground(new java.awt.Color(51, 255, 51));
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 300, 40));

        jLabel8.setFont(new java.awt.Font("OCR A Extended", 1, 16));
        jLabel8.setForeground(new java.awt.Color(51, 255, 51));
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 300, 40));

        jLabel9.setFont(new java.awt.Font("OCR A Extended", 1, 16));
        jLabel9.setForeground(new java.awt.Color(51, 255, 51));
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 300, 40));

        jLabel12.setFont(new java.awt.Font("OCR A Extended", 0, 18));
        jLabel12.setForeground(new java.awt.Color(0, 255, 0));
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 410, 30));

        jLabel13.setFont(new java.awt.Font("OCR A Extended", 0, 18));
        jLabel13.setForeground(new java.awt.Color(0, 255, 0));
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 240, 30));

        jLabel14.setFont(new java.awt.Font("OCR A Extended", 0, 18));
        jLabel14.setForeground(new java.awt.Color(0, 255, 0));
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 410, 30));

        jLabel15.setFont(new java.awt.Font("OCR A Extended", 0, 18));
        jLabel15.setForeground(new java.awt.Color(0, 255, 0));
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 580, 30));

        jLabel16.setFont(new java.awt.Font("OCR A Extended", 0, 18));
        jLabel16.setForeground(new java.awt.Color(0, 255, 0));
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 240, 30));

        jLabel17.setFont(new java.awt.Font("OCR A Extended", 0, 18));
        jLabel17.setForeground(new java.awt.Color(0, 255, 0));
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 240, 30));

        jLabel18.setFont(new java.awt.Font("OCR A Extended", 0, 18));
        jLabel18.setForeground(new java.awt.Color(0, 255, 0));
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 580, 30));

        jButton8.setText("Play Again");
        jButton8.addActionListener(evt -> jButton8ActionPerformed(evt));
        jPanel5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 120, 35));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 720, 370));

        jButton6.setText("START");
        jButton6.addActionListener(evt -> jButton6ActionPerformed(evt));
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, 150, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/409097-final.gif")));
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 670));

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1417, 826));
        setLocationRelativeTo(null);
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        playButtonSound();
        GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd2 = ge2.getDefaultScreenDevice();
        GraphicsConfiguration gc2 = gd2.getDefaultConfiguration();

        try {
            JFrame_HomeMenu homeMenu = new JFrame_HomeMenu(gc2);
            homeMenu.setVisible(true);
            this.dispose();
        } catch (URISyntaxException ex) {
            Logger.getLogger(JFrame_GameMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        playButtonSound();
        checkAnswer(0);
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        playButtonSound();
        if (jButton6.getText().equals("Start Game")) {
            currentLevel = 0;
            currentQuestionIndex = 0;
            updateLevelBackground();
            startLevelTransition();
            jButton6.setVisible(false);
        } else if (jButton6.getText().equals("Go to Next Level")) {
            currentQuestionIndex = 0;
            startLevelTransition();
            jButton6.setVisible(false);
        } else if (jButton6.getText().equals("Show Result")) {
            jButton6.setVisible(false);
            startLevelTransition();
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        playButtonSound();
        checkAnswer(1);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        playButtonSound();
        checkAnswer(2);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        playButtonSound();
        checkAnswer(3);
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame_Settings settings = new JFrame_Settings();
        settings.setVisible(true);
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame_HomePage homePage = new JFrame_HomePage();
        homePage.setUndecorated(true);
        homePage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homePage.setVisible(true);
        this.dispose();
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
}