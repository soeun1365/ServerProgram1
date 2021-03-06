package controller;

import command.member.DeleteCommand;
import command.member.JoinCommand;
import command.member.LoginCommand;
import command.member.MemberCommand;
import command.member.SelectMemberListCommand;

public class MemberCommandMapper {

	private static MemberCommandMapper instance = new MemberCommandMapper();
	private MemberCommandMapper() {}
	public static MemberCommandMapper getInstance() {
		if (instance == null) {
			instance = new MemberCommandMapper();
		}
		return instance;
	}
	
	public MemberCommand getCommand(String cmd) {
		MemberCommand command = null;
		switch (cmd) {
		case "selectMemberList.do":
			command = new SelectMemberListCommand();
			break;
		case "loginCommand.do":
			command = new LoginCommand();
			break;
		case "joinCommand.do":
			command = new JoinCommand();
			break;
		case "delete.do":
			command = new DeleteCommand();
		}
		return command;
	}
	
}
