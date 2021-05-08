/* This file was generated by SableCC (http://www.sablecc.org/). */

package assignlang.analysis;

import assignlang.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAListProgram(AListProgram node);
    void caseAStmtStatementlist(AStmtStatementlist node);
    void caseAListStatementlist(AListStatementlist node);
    void caseAAssignStatement(AAssignStatement node);
    void caseAAssignAssignrest(AAssignAssignrest node);

    void caseTIdentifier(TIdentifier node);
    void caseTOpsemicolon(TOpsemicolon node);
    void caseTOpequal(TOpequal node);
    void caseTBlank(TBlank node);
    void caseEOF(EOF node);
}