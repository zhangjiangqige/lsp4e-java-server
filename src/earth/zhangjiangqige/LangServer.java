package earth.zhangjiangqige;

import java.net.URI;
import java.util.*;

import org.eclipse.lsp4e.server.ProcessStreamConnectionProvider;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.jsonrpc.messages.Message;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseMessage;
import org.eclipse.lsp4j.services.LanguageServer;

public class LangServer extends ProcessStreamConnectionProvider {
	public LangServer() {
		System.out.println("Initializing LangServer");
		List<String> commands = new ArrayList<>();
		commands.add("/usr/bin/whoami");
		setCommands(commands);
		setWorkingDirectory(System.getProperty("user.dir"));
	}

	@Override
	public Object getInitializationOptions(URI rootUri) {
		System.out.println("LangServer getInitializationOptions");
		Map<String, Object> options = new HashMap<>();
		return options;
	}

	@Override
	public void handleMessage(Message message, LanguageServer languageServer, URI rootUri) {
		System.out.printf("LangServer handleMessage:\t%s%n\t%s%n\t%s%n", message, languageServer, rootUri);
		if (message instanceof ResponseMessage) {
			ResponseMessage responseMessage = (ResponseMessage) message;
			if (responseMessage.getResult() instanceof InitializeResult) {
			}
		}
	}

	@Override
	public String toString() {
		return "Language Server: " + super.toString();
	}
}
