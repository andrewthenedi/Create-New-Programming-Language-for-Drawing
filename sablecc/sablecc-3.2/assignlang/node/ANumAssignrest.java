/* This file was generated by SableCC (http://www.sablecc.org/). */

package assignlang.node;

import assignlang.analysis.*;

@SuppressWarnings("nls")
public final class ANumAssignrest extends PAssignrest
{
    private TNumber _number_;
    private TOpsemicolon _opsemicolon_;

    public ANumAssignrest()
    {
        // Constructor
    }

    public ANumAssignrest(
        @SuppressWarnings("hiding") TNumber _number_,
        @SuppressWarnings("hiding") TOpsemicolon _opsemicolon_)
    {
        // Constructor
        setNumber(_number_);

        setOpsemicolon(_opsemicolon_);

    }

    @Override
    public Object clone()
    {
        return new ANumAssignrest(
            cloneNode(this._number_),
            cloneNode(this._opsemicolon_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANumAssignrest(this);
    }

    public TNumber getNumber()
    {
        return this._number_;
    }

    public void setNumber(TNumber node)
    {
        if(this._number_ != null)
        {
            this._number_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._number_ = node;
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
            + toString(this._number_)
            + toString(this._opsemicolon_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._number_ == child)
        {
            this._number_ = null;
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
        if(this._number_ == oldChild)
        {
            setNumber((TNumber) newChild);
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