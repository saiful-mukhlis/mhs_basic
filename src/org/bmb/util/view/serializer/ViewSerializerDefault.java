package org.bmb.util.view.serializer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import net.infonode.docking.View;
import net.infonode.docking.ViewSerializer;

public class ViewSerializerDefault implements ViewSerializer {
	@Override
	public void writeView(View view, ObjectOutputStream out) throws IOException {
		out.writeObject(view);
	}

	public View readView(ObjectInputStream in) throws IOException {
		try {
			return (View) in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
