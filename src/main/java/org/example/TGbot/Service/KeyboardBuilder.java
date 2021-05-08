package org.example.TGbot.Service;

import org.example.TGbot.Game.Question;
import org.example.TGbot.STATE;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyboardBuilder {

    public static InlineKeyboardMarkup InlineKeyBoard(Question questions) {


        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText(questions.ans1);
        inlineKeyboardButton1.setCallbackData("1");
        inlineKeyboardButton2.setText(questions.ans2);
        inlineKeyboardButton2.setCallbackData("2");
        inlineKeyboardButton3.setText(questions.ans3);
        inlineKeyboardButton3.setCallbackData("3");
        inlineKeyboardButton4.setText(questions.ans4);
        inlineKeyboardButton4.setCallbackData("4");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(inlineKeyboardButton3);
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        keyboardButtonsRow2.add(inlineKeyboardButton4);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        inlineKeyboardMarkup.setKeyboard(rowList);


        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup InlineKeyBoard(STATE state) {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("no");
        inlineKeyboardButton1.setCallbackData("nothing");
        inlineKeyboardButton2.setText("yes");
        inlineKeyboardButton2.setCallbackData("again");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();

        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(inlineKeyboardButton2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);

        inlineKeyboardMarkup.setKeyboard(rowList);


        return inlineKeyboardMarkup;
    }

        public static InlineKeyboardMarkup InlineKeyBoard(){


        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("i'm newby");
        inlineKeyboardButton1.setCallbackData("db");
        inlineKeyboardButton2.setText("start game");
        inlineKeyboardButton2.setCallbackData("game");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();

        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(inlineKeyboardButton2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);

        inlineKeyboardMarkup.setKeyboard(rowList);


        return inlineKeyboardMarkup;

    }
}
