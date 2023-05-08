package com.example.lab1.accessors;

import com.example.lab1.commands.ICommand;
import com.example.lab1.commands.error.BadRequestCommand;
import jakarta.ejb.Local;
import jakarta.ws.rs.HttpMethod;

import java.util.HashMap;
import java.util.Map;

@Local
public abstract class HttpCommandAccessor {
    private final Map<String, Map<String, ICommand>> _commands;

    public HttpCommandAccessor() {
        _commands = new HashMap<>();
        _commands.put(HttpMethod.GET, new HashMap<>());
        _commands.put(HttpMethod.POST, new HashMap<>());
        _commands.put(HttpMethod.PUT, new HashMap<>());
        _commands.put(HttpMethod.DELETE, new HashMap<>());
    }

    public ICommand getHttpGetCommand(String urlPath) {
        return getCommand(HttpMethod.GET, urlPath);
    }

    public ICommand getHttpPostCommand(String urlPath) {
        return getCommand(HttpMethod.POST, urlPath);
    }

    public ICommand getHttpPutCommand(String urlPath) {
        return getCommand(HttpMethod.PUT, urlPath);
    }

    public ICommand getHttpDeleteCommand(String urlPath) {
        return getCommand(HttpMethod.DELETE, urlPath);
    }

    protected void registerHttpGetCommand(String urlPath, ICommand command) {
        putCommand(HttpMethod.GET, command, urlPath);
    }

    protected void registerHttpPostCommand(String urlPath, ICommand command) {
        putCommand(HttpMethod.POST, command, urlPath);
    }

    protected void registerHttpPutCommand(String urlPath, ICommand command) {
        putCommand(HttpMethod.PUT, command, urlPath);
    }

    protected void registerHttpDeleteCommand(String urlPath, ICommand command) {
        putCommand(HttpMethod.DELETE, command, urlPath);
    }

    private void putCommand(String httpMethod, ICommand command, String urlPath) {
        _commands.get(httpMethod).put(urlPath, command);
    }

    private ICommand getCommand(String httpMethod, String urlPath) {
        return _commands.get(httpMethod).getOrDefault(urlPath, new BadRequestCommand());
    }
}
