/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramit5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author peera
 */
public class FXMLGameController implements Initializable {

    private Text playername;
    private boolean gameend = false ;
    private String name = "";
    private int score = 0 ;
    private String scoreStr = "0" ;

    private int posX = 0;
    private int posY = 0;

    private int count = 0;

    @FXML
    private ImageView pos00, pos10, pos11, pos20, pos21, pos22, pos30, pos31, pos32, pos33, pos40, pos41, pos42, pos43, pos44, pos50, pos51, pos52, pos53, pos54, pos55, pos60, pos61, pos62, pos63, pos64, pos65, pos66;
    @FXML
    private ImageView setCardImage;
    @FXML
    private ImageView flipedCardImage;
    @FXML
    private Button drawButton;

    private ArrayList<Card> deck = new ArrayList<>();

    private Card[][] playCardPos = new Card[7][7];

    private boolean isExist[][] = new boolean[7][7];

    private boolean clickable[][] = new boolean[7][7];

    List<String> suits = Card.getValidSuit();
    List<String> cardNumbers = Card.getValidCardNumber();

    private ArrayList<ImageView> imageViews = new ArrayList<>();
    @FXML
    private Text playerscore;

    
    
    
    
    
    private void addImageViewToArrayList() {
        imageViews.add(pos00);
        imageViews.add(pos10);
        imageViews.add(pos11);
        imageViews.add(pos20);
        imageViews.add(pos21);
        imageViews.add(pos22);
        imageViews.add(pos30);
        imageViews.add(pos31);
        imageViews.add(pos32);
        imageViews.add(pos33);
        imageViews.add(pos40);
        imageViews.add(pos41);
        imageViews.add(pos42);
        imageViews.add(pos43);
        imageViews.add(pos44);
        imageViews.add(pos50);
        imageViews.add(pos51);
        imageViews.add(pos52);
        imageViews.add(pos53);
        imageViews.add(pos54);
        imageViews.add(pos55);
        imageViews.add(pos60);
        imageViews.add(pos61);
        imageViews.add(pos62);
        imageViews.add(pos63);
        imageViews.add(pos64);
        imageViews.add(pos65);
        imageViews.add(pos66);
    }

    private int cardInDeckCounter;

    private Card[] valueOfSelectedCard = new Card[2];

    private int selectedCounter = 0;

    int value[] = new int[2];
    int posChooseX[] = new int[2];
    int posChooseY[] = new int[2];
    int counter = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
        FileReader filename = new FileReader("Playername");
        BufferedReader br1 = new BufferedReader (filename);
        name =  br1.readLine();
        br1.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        playerscore.setText("0");
        gameSetUp();
    }

    @FXML
    private void drawCardButtonClicked(ActionEvent event) {
        drawDeckCard();
        //flipedCardImage.setImage(deck.drawCard().getCardImage());
    }

    private void gameSetUp() {

        setCardImage.setVisible(true);
        flipedCardImage.setDisable(true);
        for (String suit : suits) {
            for (String cardNumber : cardNumbers) {
                deck.add(new Card(cardNumber, suit, null));
                //deck.get(i).setImageView(imageViews.get(i));
            }
        }
        shuffle();
        addImageViewToArrayList();
        transferToPlayCardPos();
        cardInDeckCounter = deck.size();
        for (int a = 0; a < 7; a++) {
            for (int b = 0; b <= a; b++) {
                isExist[a][b] = true;
                clickable[a][b] = false;
            }
        }
        checkClickable();
    }

    private void checkClickable() {
        for (int temp1 = 0; temp1 < 7; temp1++) {
            if (temp1 == 6 ) {
                for (int temp2 = 0; temp2 <= temp1; temp2++) {
                    clickable[temp1][temp2] = true;
                }
            } else if (temp1 < 6) {
                for (int temp3 = 0; temp3 <= temp1; temp3++) {
                    if (isExist[temp1 + 1][temp3] == false && isExist[temp1 + 1][temp3 + 1] == false) {
                        clickable[temp1][temp3] = true;
                    }
                }  
            }           
      
            
            else System.out.println("error");
        }
    }

    @FXML
    private void chooseCard(MouseEvent event) {
        if (event.getSource() == pos00 && clickable[0][0]) {
            posY = 0;
            posX = 0;
        } else if (event.getSource() == pos10 && clickable[1][0]) {
            posY = 1;
            posX = 0;
        } else if (event.getSource() == pos11 && clickable[1][1]) {
            posY = 1;
            posX = 1;
        } else if (event.getSource() == pos20 && clickable[2][0]) {
            posY = 2;
            posX = 0;
        } else if (event.getSource() == pos21 && clickable[2][1]) {
            posY = 2;
            posX = 1;
        } else if (event.getSource() == pos22 && clickable[2][2]) {
            posY = 2;
            posX = 2;
        } else if (event.getSource() == pos30 && clickable[3][0]) {
            posY = 3;
            posX = 0;
        } else if (event.getSource() == pos31 && clickable[3][1]) {
            posY = 3;
            posX = 1;
        } else if (event.getSource() == pos32 && clickable[3][2]) {
            posY = 3;
            posX = 2;
        } else if (event.getSource() == pos33 && clickable[3][3]) {
            posY = 3;
            posX = 3;
        } else if (event.getSource() == pos40 && clickable[4][0]) {
            posY = 4;
            posX = 0;
        } else if (event.getSource() == pos41 && clickable[4][1]) {
            posY = 4;
            posX = 1;
        } else if (event.getSource() == pos42 && clickable[4][2]) {
            posY = 4;
            posX = 2;
        } else if (event.getSource() == pos43 && clickable[4][3]) {
            posY = 4;
            posX = 3;
        } else if (event.getSource() == pos44 && clickable[4][4]) {
            posY = 4;
            posX = 4;
        } else if (event.getSource() == pos50 && clickable[5][0]) {
            posY = 5;
            posX = 0;
        } else if (event.getSource() == pos51 && clickable[5][1]) {
            posY = 5;
            posX = 1;
        } else if (event.getSource() == pos52 && clickable[5][2]) {
            posY = 5;
            posX = 2;
        } else if (event.getSource() == pos53 && clickable[5][3]) {
            posY = 5;
            posX = 3;
        } else if (event.getSource() == pos54 && clickable[5][4]) {
            posY = 5;
            posX = 4;
        } else if (event.getSource() == pos55 && clickable[5][5]) {
            posY = 5;
            posX = 5;
        } else if (event.getSource() == pos60 && clickable[6][0]) {
            posY = 6;
            posX = 0;
        } else if (event.getSource() == pos61 && clickable[6][1]) {
            posY = 6;
            posX = 1;
        } else if (event.getSource() == pos62 && clickable[6][2]) {
            posY = 6;
            posX = 2;
        } else if (event.getSource() == pos63 && clickable[6][3]) {
            posY = 6;
            posX = 3;
        } else if (event.getSource() == pos64 && clickable[6][4]) {
            posY = 6;
            posX = 4;
        } else if (event.getSource() == pos65 && clickable[6][5]) {
            posY = 6;
            posX = 5;
        } else if (event.getSource() == pos66 && clickable[6][6]) {
            posY = 6;
            posX = 6;
        } else if (event.getSource() == flipedCardImage) {
            posY = 0;
            posX = 6;
        } else {
            posX = -1;
            posY = -1;
        }

        //CHECK ALL CONDITIONS
        if (posY == 0 && posX == 6) {
            setPos(posY,posX);
            if (getCardValue(posY, posX) == 13) {
                deck.remove(0);
                drawDeckCard();
            }
        }
            
        if (posX >= 0 || posY >= 0) {
            setPos(posY, posX);

            // FIRST CONDITION 
            //checkChooseCard(posY, posX);
            System.out.println(getCardValue(posY, posX));

            if (getCardValue(posY, posX) == 13) {
                playCardPos[posY][posX].getImageView().setVisible(false);
                isExist[posY][posX] = false ;
                score += 70 ;
                scoreStr = Integer.toString(score);
                playerscore.setText(scoreStr);
                
            } else {
                posChooseX[counter] = posX;
                posChooseY[counter] = posY;
                counter++;
                System.out.println(counter);

                if (counter > 1) {
                    calculate(getCardValue(posChooseY[0], posChooseX[0]), getCardValue(posChooseY[1], posChooseX[1]));
                    counter = 0;
                }
            }
        }
    }

    private void calculate(int a, int b)  {
        if (a + b == 13) {
            System.out.println("MATCH");
            playCardPos[posChooseY[0]][posChooseX[0]].getImageView().setVisible(false);
            playCardPos[posChooseY[1]][posChooseX[1]].getImageView().setVisible(false);
            isExist[posChooseY[0]][posChooseX[0]] = false;
            isExist[posChooseY[1]][posChooseX[1]] = false;
         
            if(posChooseY[0] == 0 && posChooseX[0] == 6 ) {
                drawDeckCard();
            }
            else if(posChooseY[1] == 0 && posChooseX[1] == 6 ) {
                drawDeckCard();
            }
            checkClickable();
       
            if( playCardPos[posChooseY[0]][posChooseX[0]].getSuit().equals(playCardPos[posChooseY[1]][posChooseX[1]].getSuit()) )
            {
                   score += 100 ;
            }
            else 
            {
                score += 50 ;
            }
         
            scoreStr = Integer.toString(score);
            playerscore.setText(scoreStr);
            
            if(isExist[0][0] == false )
            {              
                gameend = true ;
                chackgameEnd();
            }
            
            
        } else {
            System.out.println("FAIL");
        }
    
       
       
    }

    private void setPos(int posY, int posX) {
        playCardPos[posY][posX].setPosX(posX);
        playCardPos[posY][posX].setPosY(posY);
    }

    private int getCardValue(int posY, int posX) {
        return playCardPos[posY][posX].getCardNumber();
    }

    private Card checkChooseCard(int posY, int posX) {

        if (clickable[posY][posX]) {
            return playCardPos[posY][posX];
        } else {
            return playCardPos[0][1];
        }
    }

    private void shuffle() {
        Collections.shuffle(deck);
    }

    private void transferToPlayCardPos() {
        int transferCounter = 0;
        Card[] tempCard = new Card[52];
        for (int a = 0; a < 52; a++) {
            tempCard[a] = deck.get(a);
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                playCardPos[i][j] = tempCard[transferCounter];
                playCardPos[i][j].setImageView(imageViews.get(transferCounter));
                playCardPos[i][j].getImageView().setImage((playCardPos[i][j].getCardImage()));
                deck.remove(0);
                transferCounter++;
            }
        }
    }

    private void drawDeckCard() {
        flipedCardImage.setDisable(false);
        if (deck.size() > 0) {
            Card tempCard = deck.get(0);
            deck.remove(0);
            flipedCardImage.setImage(deck.get(0).getCardImage());
            deck.add(tempCard);
            playCardPos[0][6] = deck.get(0);
            
        }
        
        
    }
        private void chackgameEnd()
        {
            try{
                    FileWriter file2 = new FileWriter("score.txt");
                    BufferedWriter bw2 = new BufferedWriter(file2);
                    bw2.write(scoreStr);
                    bw2.close();
                
            }
            catch( IOException ex)
            {
                ex.printStackTrace();
            }
        }
        
    
    
    
    
    
}