package ex2;

/**
 * The type Answer.
 */
public class Answer
{
    private String theAnswer;
    private String name;
    private int idQ;

    /**
     * Instantiates a new Answer.
     *
     * @param Answer the answer
     * @param name   the name
     * @param idQ    the id q
     */
    public Answer(String Answer , String name,int idQ)
    {
        this.idQ = idQ;
        theAnswer = Answer;
        this.name = name;
    }

    /**
     * Instantiates a new Answer.
     *
     * @param Answer the answer
     * @param name   the name
     */
    public  Answer(String Answer , String name)
    {
        this.idQ = 1;
        theAnswer = Answer;
        this.name = name;
    }

    /**
     * Gets the answer.
     *
     * @return the the answer
     */
    public String getTheAnswer()
    {
        return theAnswer;
    }

    /**
     * Sets the answer.
     *
     * @param theAnswer the the answer
     */
    public void setTheAnswer(String theAnswer) {
        this.theAnswer = theAnswer;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets id q.
     *
     * @return the id q
     */
    public int getIdQ() {
        return idQ;
    }

    /**
     * Sets id q.
     *
     * @param idQ the id q
     */
    public void setIdQ(int idQ) {
        this.idQ = idQ;
    }
}
