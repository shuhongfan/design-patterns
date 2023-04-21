package com.shf.design.structural.adapter.clazz;

import com.shf.design.structural.adapter.Player;
import com.shf.design.structural.adapter.Zh_JPTranslator;

public class JPMoviePlayerAdapter extends Zh_JPTranslator implements Player {

//    被适配对象
    private Player target;

    public JPMoviePlayerAdapter(Player target) {
        this.target = target;
    }

    @Override
    public String play() {
        String play = target.play();
//        转换字幕
        String translate = translate(play);
        System.out.println("日文:" + translate);
        return translate;
    }
}
