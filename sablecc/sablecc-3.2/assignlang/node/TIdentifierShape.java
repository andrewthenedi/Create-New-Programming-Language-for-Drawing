/* This file was generated by SableCC (http://www.sablecc.org/). */

package assignlang.node;

import assignlang.analysis.*;

@SuppressWarnings("nls")
public final class TIdentifierShape extends Token
{
    public TIdentifierShape(String text)
    {
        setText(text);
    }

    public TIdentifierShape(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TIdentifierShape(getText(), getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTIdentifierShape(this);
    }
}
