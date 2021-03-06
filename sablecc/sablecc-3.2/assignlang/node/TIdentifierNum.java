/* This file was generated by SableCC (http://www.sablecc.org/). */

package assignlang.node;

import assignlang.analysis.*;

@SuppressWarnings("nls")
public final class TIdentifierNum extends Token
{
    public TIdentifierNum(String text)
    {
        setText(text);
    }

    public TIdentifierNum(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TIdentifierNum(getText(), getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTIdentifierNum(this);
    }
}
