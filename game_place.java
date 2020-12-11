package com.example.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class game_place extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    ImageButton replay_btn;
    int x_score , o_score;
    TextView current_turn_field , x_score_field , o_score_field;
    String current_turn;

    String keypad[] = new String[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_place);



        x_score = 0;
        o_score = 0;
        set_score(x_score , o_score);



        b1 = (Button)findViewById(R.id.btn1);
        b2 = (Button)findViewById(R.id.btn2);
        b3 = (Button)findViewById(R.id.btn3);
        b4 = (Button)findViewById(R.id.btn4);
        b5 = (Button)findViewById(R.id.btn5);
        b6 = (Button)findViewById(R.id.btn6);
        b7 = (Button)findViewById(R.id.btn7);
        b8 = (Button)findViewById(R.id.btn8);
        b9 = (Button)findViewById(R.id.btn9);

        initial_conditions(); // to set keypad empty and current turn is X

        click(b1);
        click(b2);
        click(b3);
        click(b4);
        click(b5);
        click(b6);
        click(b7);
        click(b8);
        click(b9);


        replay_btn = findViewById(R.id.replay_btn);
        replay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initial_conditions();
            }
        });





    }

    public String change_turn(String current_turn)
    {
        if (current_turn == "X")
        {
            return "O";
        }
        else
        {
            return "X";
        }
    }

    public void set_score(int x_score , int o_score)
    {
        x_score_field = findViewById(R.id.x_player_score_field);
        o_score_field = findViewById(R.id.o_player_score_field);
        x_score_field.setText("X Score: " + x_score);
        o_score_field.setText("O Score: " + o_score);
    }

    public void set_turn(String current_turn)
    {
        current_turn_field = findViewById(R.id.player_turn_field);
        current_turn_field.setText(current_turn);
    }

    public void click(final Button btn)
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setText(current_turn);
                btn.setClickable(false);

                if (btn.getId() == R.id.btn1) {
                    keypad[1] = current_turn;
                }
                else if(btn.getId() == R.id.btn2)
                {
                    keypad[2] = current_turn;
                }
                else if(btn.getId() == R.id.btn3)
                {
                    keypad[3] = current_turn;
                }
                else if(btn.getId() == R.id.btn4)
                {
                    keypad[4] = current_turn;
                }
                else if(btn.getId() == R.id.btn5)
                {
                    keypad[5] = current_turn;
                }
                else if(btn.getId() == R.id.btn6)
                {
                    keypad[6] = current_turn;
                }
                else if(btn.getId() == R.id.btn7)
                {
                    keypad[7] = current_turn;
                }
                else if(btn.getId() == R.id.btn8)
                {
                    keypad[8] = current_turn;
                }
                else if(btn.getId() == R.id.btn9)
                {
                    keypad[9] = current_turn;
                }


                current_turn = change_turn(current_turn);
                set_turn(current_turn +"'s Turn");
                String winner = check_for_win();
                if(winner.equals("X"))
                {
                    buttons_condition(false);
                    x_score++;
                    set_turn("X is the Winner");
                    set_score(x_score , o_score);
                    Toast.makeText(view.getContext() , "X Player is the Winner" , Toast.LENGTH_LONG).show();
                }
                else if(winner.equals("O"))
                {
                    buttons_condition(false);
                    o_score++;
                    set_turn("O is the winner");
                    set_score(x_score , o_score);
                    Toast.makeText(view.getContext() , "O Player is the Winner" , Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public String check_for_win()
    {
        if(keypad[1].equals(keypad[2]) && keypad[2].equals(keypad[3]))
        {
            return keypad[1];
        }
        else if(keypad[4].equals(keypad[5]) && keypad[5].equals(keypad[6]))
        {
            return keypad[4];
        }
        else if(keypad[7].equals(keypad[8]) && keypad[8].equals(keypad[9]))
        {
            return keypad[7];
        }
        else if(keypad[1].equals(keypad[4]) && keypad[4].equals(keypad[7]))
        {
            return keypad[1];
        }
        else if(keypad[2].equals(keypad[5]) && keypad[5].equals(keypad[8]))
        {
            return keypad[2];
        }
        else if(keypad[3].equals(keypad[6]) && keypad[6].equals(keypad[9]))
        {
            return keypad[3];
        }
        else if(keypad[1].equals(keypad[5]) && keypad[5].equals(keypad[9]))
        {
            return keypad[1];
        }
        else if(keypad[3].equals(keypad[5]) && keypad[5].equals(keypad[7]))
        {
            return keypad[3];
        }
        else
        {
            return "NO WINNER";
        }
    }

    public void clear()
    {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
    }

    public void buttons_condition(boolean cond)
    {
        b1.setClickable(cond);
        b2.setClickable(cond);
        b3.setClickable(cond);
        b4.setClickable(cond);
        b5.setClickable(cond);
        b6.setClickable(cond);
        b7.setClickable(cond);
        b8.setClickable(cond);
        b9.setClickable(cond);
    }

    public void initial_conditions()
    {
        clear();
        buttons_condition(true);
        for(int i =0; i < 10 ; i++)
        {
            keypad[i] = "n";
            current_turn = "X";
            set_turn(current_turn + "'s Turn");
        }
    }

}