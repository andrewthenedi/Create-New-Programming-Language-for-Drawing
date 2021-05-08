/* This file was generated by SableCC (http://www.sablecc.org/). */

package assignlang.node;

import assignlang.analysis.*;

@SuppressWarnings("nls")
public final class AListStatementlist extends PStatementlist
{
    private PStatement _statement_;
    private PStatementlist _statementlist_;

    public AListStatementlist()
    {
        // Constructor
    }

    public AListStatementlist(
        @SuppressWarnings("hiding") PStatement _statement_,
        @SuppressWarnings("hiding") PStatementlist _statementlist_)
    {
        // Constructor
        setStatement(_statement_);

        setStatementlist(_statementlist_);

    }

    @Override
    public Object clone()
    {
        return new AListStatementlist(
            cloneNode(this._statement_),
            cloneNode(this._statementlist_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAListStatementlist(this);
    }

    public PStatement getStatement()
    {
        return this._statement_;
    }

    public void setStatement(PStatement node)
    {
        if(this._statement_ != null)
        {
            this._statement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._statement_ = node;
    }

    public PStatementlist getStatementlist()
    {
        return this._statementlist_;
    }

    public void setStatementlist(PStatementlist node)
    {
        if(this._statementlist_ != null)
        {
            this._statementlist_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._statementlist_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._statement_)
            + toString(this._statementlist_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._statement_ == child)
        {
            this._statement_ = null;
            return;
        }

        if(this._statementlist_ == child)
        {
            this._statementlist_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._statement_ == oldChild)
        {
            setStatement((PStatement) newChild);
            return;
        }

        if(this._statementlist_ == oldChild)
        {
            setStatementlist((PStatementlist) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}