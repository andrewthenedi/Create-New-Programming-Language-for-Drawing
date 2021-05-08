/* This file was generated by SableCC (http://www.sablecc.org/). */

package assignlang.node;

import assignlang.analysis.*;

@SuppressWarnings("nls")
public final class TIdentifierYCurrent extends Token
{
    public TIdentifierYCurrent(String text)
    {
        setText(text);
    }

    public TIdentifierYCurrent(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TIdentifierYCurrent(getText(), getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTIdentifierYCurrent(this);
    }
}