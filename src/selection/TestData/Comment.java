package TestData;

/**
* Comment.java is just a test data class until
* we have real data from Extraction team.
* @author Brooke Tibbett
*/
public class Comment
{
    private String text;

	/**
	* Comment constructor.
	*/
    public Comment()
    {
        text = "";
    }

	/**
	* Accessor for text.
	* @return actual text from comment
	*/
    public String getText()
    {
        return text;
    }

    /**
     * Mutator for text just for testing purposes.
     * @param text string
     */
    public void setText(String text)
    {
        this.text = text;
    }
}
