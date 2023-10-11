package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.templates.type.ButtonType;

/**
 * The type MPM button.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlowButton extends Button {

    @JsonProperty("flow_id")
    private Long flowId;

    @JsonProperty("flow_action")
    private String flowAction;

    @JsonProperty("navigate_screen")
    private String navigateScreen;


    /**
     * Instantiates a new FLOW button.
     *
     * @param text the text
     */
    public FlowButton(String text, long flowId, String flowAction, String navigateScreen) {
        super(ButtonType.FLOW, text);
        this.flowId = flowId;
        this.flowAction = flowAction;
        this.navigateScreen = navigateScreen;
    }


	public Long getFlowId() {
		return flowId;
	}


	public FlowButton setFlowId(Long flowId) {
		this.flowId = flowId;
		return this;
	}


	public String getFlowAction() {
		return flowAction;
	}


	public FlowButton setFlowAction(String flowAction) {
		this.flowAction = flowAction;
		return this;
	}


	public String getNavigateScreen() {
		return navigateScreen;
	}


	public FlowButton setNavigateScreen(String navigateScreen) {
		this.navigateScreen = navigateScreen;
		return this;
	}

}
