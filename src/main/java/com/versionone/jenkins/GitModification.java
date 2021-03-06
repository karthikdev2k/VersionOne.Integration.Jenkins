package com.versionone.jenkins;

import hudson.plugins.git.GitChangeSet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.versionone.integration.ciCommon.VcsModification;

public class GitModification implements VcsModification {
    private DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
	private GitChangeSet _entry;
	
	public GitModification(GitChangeSet entry) {
		_entry = entry;
	}
	
	public String getComment() {
		return _entry.getComment();
	}

	public Date getDate()  {
        try {
            return fmt.parse(_entry.getDate());
        } catch (ParseException ex) {
            ex.printStackTrace();
            return Calendar.getInstance().getTime();
        }
	}

	public String getId() {
		return _entry.getId();
	}

	public String getUserName() {
		return _entry.getAuthorName();
	}

}
