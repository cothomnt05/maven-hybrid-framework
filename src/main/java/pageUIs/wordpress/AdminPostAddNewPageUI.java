package pageUIs.wordpress;

public class AdminPostAddNewPageUI {
	public static final String TITLE_TEXTBOX = "css=h1.wp-block-post-title";
	public static final String BODY_BUTTON = "css=p.block-editor-default-block-appender__content";
	public static final String BODY_TEXTBOX = "css=p.block-editor-rich-text__editable";
	public static final String PUBLISH_BUTTON = "css=button.editor-post-publish-panel__toggle";
	public static final String PRE_PUBLISH_BUTTON = "css=button.editor-post-publish-button";
	public static final String PUBLISHED_MESSAGE = "xpath=//div[@class = 'components-snackbar__content' and contains(text(),'%s') ]";
}
