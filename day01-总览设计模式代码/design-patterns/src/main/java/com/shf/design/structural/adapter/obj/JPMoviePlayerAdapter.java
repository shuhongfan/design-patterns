package com.shf.design.structural.adapter.obj;

import com.shf.design.structural.adapter.Player;
import com.shf.design.structural.adapter.Translator;
import com.shf.design.structural.adapter.Zh_JPTranslator;

public class JPMoviePlayerAdapter implements Player {
//    组合方式
    private Translator translator = new Zh_JPTranslator();
    private Player target;

    public JPMoviePlayerAdapter(Player target) {
        this.target = target;
    }

    @Override
    public String play() {
        String play = target.play();
        String translate = translator.translate(play);
        System.out.println("日文：" + translate);
        return play;
    }
}
