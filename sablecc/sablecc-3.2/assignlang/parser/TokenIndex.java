/* This file was generated by SableCC (http://www.sablecc.org/). */

package assignlang.parser;

import assignlang.node.*;
import assignlang.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTIdentifier(@SuppressWarnings("unused") TIdentifier node)
    {
        this.index = 0;
    }

    @Override
    public void caseTOpsemicolon(@SuppressWarnings("unused") TOpsemicolon node)
    {
        this.index = 1;
    }

    @Override
    public void caseTOpequal(@SuppressWarnings("unused") TOpequal node)
    {
        this.index = 2;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 3;
    }
}