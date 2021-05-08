/* This file was generated by SableCC (http://www.sablecc.org/). */

package assignlang.node;

import assignlang.analysis.*;

@SuppressWarnings("nls")
public final class AAssignrest extends PAssignrest
{
    private TColor _color_;
    private TOpsemicolon _opsemicolon_;

    public AAssignrest()
    {
        // Constructor
    }

    public AAssignrest(
        @SuppressWarnings("hiding") TColor _color_,
        @SuppressWarnings("hiding") TOpsemicolon _opsemicolon_)
    {
        // Constructor
        setColor(_color_);

        setOpsemicolon(_opsemicolon_);

    }

    @Override
    public Object clone()
    {
        return new AAssignrest(
            cloneNode(this._color_),
            cloneNode(this._opsemicolon_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAssignrest(this);
    }

    public TColor getColor()
    {
        return this._color_;
    }

    public void setColor(TColor node)
    {
        if(this._color_ != null)
        {
            this._color_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._color_ = node;
    }

    public TOpsemicolon getOpsemicolon()
    {
        return this._opsemicolon_;
    }

    public void setOpsemicolon(TOpsemicolon node)
    {
        if(this._opsemicolon_ != null)
        {
            this._opsemicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._opsemicolon_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._color_)
            + toString(this._opsemicolon_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._color_ == child)
        {
            this._color_ = null;
            return;
        }

        if(this._opsemicolon_ == child)
        {
            this._opsemicolon_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._color_ == oldChild)
        {
            setColor((TColor) newChild);
            return;
        }

        if(this._opsemicolon_ == oldChild)
        {
            setOpsemicolon((TOpsemicolon) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
