/*
 * Copyright 2010-2011 LinkedIn Corporation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * 
 */
package com.linkedin.bowser.core.functions;

import java.util.Map;

import com.linkedin.bowser.core.eval.EvalHandler;
import com.linkedin.bowser.core.objects.NQLObject;

/**
 * @author sdawson
 * 
 */
public class Max extends AbstractNQLFunction implements NQLFunction
{
  /*
   * (non-Javadoc)
   * 
   * @see com.linkedin.nql.core.functions.Function#getName()
   */
  @Override
  public String getName()
  {
    return "max";
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.linkedin.nql.core.functions.Function#apply(java.util.List)
   */
  @Override
  public NQLObject apply(Map<String, NQLObject> globals,
                         java.util.List<NQLObject> arguments)
  {
    NQLObject car = arguments.get(0);
    for (NQLObject cdr : arguments.subList(1, arguments.size()))
    {
      if (EvalHandler.gt(cdr, car))
        car = cdr;
    }

    return car;
  }
}
