/* This file was generated by SableCC (http://www.sablecc.org/). */

package assignlang.node;

import assignlang.analysis.*;

@SuppressWarnings("nls")
public final class TColorShapeNumber extends Token
{
    public TColorShapeNumber(String text)
    {
        setText(text);
    }

    public TColorShapeNumber(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TColorShapeNumber(getText(), getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTColorShapeNumber(this);
    }
}
