package entities;

import java.time.Instant;

public class LogEntry implements Comparable<LogEntry> {
    private String username;
    private Instant accessTimeInstant;

    public LogEntry() {}

    public LogEntry(String username, Instant accessTimeInstant) {
        this.username = username;
        this.accessTimeInstant = accessTimeInstant;
    }

    public String getUsername() {
        return this.username;
    }

    public Instant getAccessTimeInstant() {
        return this.accessTimeInstant;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setAccessTimeInstant(Instant accessTimeInstant) {
        this.accessTimeInstant = accessTimeInstant;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

    @Override
    public int compareTo(LogEntry other) {
        return this.username.compareTo(other.username);
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogEntry other = (LogEntry) obj;
		if (this.username == null) {
			if (other.username != null)
				return false;
		} else if (!this.username.equals(other.username))
			return false;
		return true;
	}
}